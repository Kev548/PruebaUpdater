
/*=========================================
              VARIABLES GLOBALES
  =========================================*/
let Data;
let DataCopia;
let ServicioActivoTigo = 0;
let ServicioActivoClaro = 0;
let graficalineal;
let Fecha = new Date();
let Meses = ["ENERO", "FEBREO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"];
let Hoy;
let Saldo;
let Leyenda;
let Max_Saldo;
let Med_Saldo;
let Min_Saldo;
let CacheModal;

let ModalMax;
let ModalMed;
let ModalMin;

let UserTelefonia;






/*================================================================================================================= CODIGO ================================================================================================================= */




/*=======================================================
       METODO QUE CARGA LOS VALORES PREDETERMINADOS
                CUANDO SE RECARGA LA PAGINA
  =======================================================*/
function OnLoadSetting() {

  

    try {
        UserTelefonia = localStorage.getItem('UsuarioLogged');

        getLimite();

        let date = new Date()
        let day = date.getDate()
        let month = date.getMonth() + 1
        let year = date.getFullYear()


        if (month < 10) {
            Hoy = (`${day}/0${month}/${year}`)
        } else {
            Hoy = (`${day}/${month}/${year}`)
        }
        document.getElementById('TituloTransacciones').innerHTML = 'Total de transacciones hoy ' + Hoy;
        document.getElementById('TituloTotalVendidoMes').innerHTML = 'Total de vendido de ' + Meses[date.getMonth()];
        Leyenda = ' DE ' + Meses[date.getMonth()];
        EstadosPorDia(Hoy, Hoy);
        Get_ParameterTigo();
        Get_ParameterClaro();
        TrazaSaldo(Hoy, Hoy, 0);

        //INICIALIZAN LOS DATE PICKERS Y LOS CAMBIA A ESPAÑOL
        $(document).ready(function () {
            $('.datepicker').datepicker();

            $('.datepicker').datepicker({
                firstDay: true,
                format: 'dd/mm/yyyy',
                i18n: {
                    months: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
                    monthsShort: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Set", "Oct", "Nov", "Dic"],
                    weekdays: ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"],
                    weekdaysShort: ["Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab"],
                    weekdaysAbbrev: ["D", "L", "M", "M", "J", "V", "S"]
                }
            });
        });

        
        //INICIALIZA LOS MODALES
        $(document).ready(function () {
            $('.modal').modal();
        });
    } catch (e) {
        console.log('Error OnLoadSetting' + e)
    }

}


/*=======================================================
         METODO BUSCA LA INFORMACION ENTRE FECHA 
            SE MANDA FECHA INICIO Y FECHA FIN
  =======================================================*/
function BuscarFechas(inicia, finaliza) {

    try {
        if (inicia.value != "") {
            if (inicia.includes('/')) {
                if (finaliza.value != "") {
                    if (finaliza.includes('/')) {
                        document.getElementById('TituloTransacciones').innerHTML = 'Total de transacciones desde ' + inicia + ' hasta ' + finaliza;
                        EstadosPorDia(inicia, finaliza);
                        Get_ParameterTigo();
                        Get_ParameterClaro();
                        Leyenda = ' DESDE ' + inicia + ' HASTA ' + finaliza;
                        document.getElementById('TituloTotalVendidoMes').innerHTML = 'Total de vendido desde ' + inicia + ' hasta ' + finaliza;
                        TrazaSaldo(inicia, finaliza, 1);
                    } else {
                        M.toast({ html: 'PorFavor Ingrese una Fecha Valida' });
                    }
                } else {
                    M.toast({ html: 'PorFavor Ingrese una Fecha Valida' });
                }
            } else {
                M.toast({ html: 'PorFavor Ingrese una Fecha Valida' });
            }
        } else {
            M.toast({ html: 'PorFavor Ingrese una Fecha Valida' });
        }
    } catch (e) {
        console.log('Error BuscarFechas ' + e)
    }
}

/*================================================================
             EXTRAE LA DATA DE DENEGADAS, NO ENVIADAS
           Y CALCULA EL TOTAL DE TRANSACCIONES POR FECHA
  ================================================================*/
function EstadosPorDia(inicia, finaliza) {
    try {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "/Telefonia/GetEstadosPorDia",
            data: { FechaIni: inicia, FechaFin: finaliza },
            contentType: "application/json; charset=utf-8",
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('jqXHR:');
                console.log(jqXHR);
                console.log('textStatus:');
                console.log(textStatus);
                console.log('errorThrown:');
                console.log(errorThrown);

            },
            success: function (result) {
                if (JSON.stringify(result).includes('ERROR:') == false) {
                    console.log(result[0])
                    Data = result
                    $.each(Data, function (key, value) {
                        document.getElementById('recargas-denegadas').innerHTML = value.ERROR_EN_RECARGA;
                        document.getElementById('recargas-no-enviadas').innerHTML = value.NO_ENVIADO;
                        document.getElementById('recargas-enviadas').innerHTML = value.RECARGA_REALIZADA;
                        document.getElementById('recargas-total-transacciones').innerHTML = parseInt(document.getElementById('recargas-denegadas').innerHTML) + parseInt(document.getElementById('recargas-no-enviadas').innerHTML) + parseInt(document.getElementById('recargas-enviadas').innerHTML);
                    });
                } else {
                    M.toast({ html: "ERROR: LA FECHA DE INICIO ES MAYOR A LA FECHA QUE FINALIZA" });
                }
            }
        });
    } catch (e) {
        console.log('Error EstadosPorDia ' + e)
    }


}

/*================================================================
          TRAE DE LOS PARAMETROS EL ESTADO DEL SERVICIO TIGO
  ================================================================*/
function Get_ParameterTigo() {
    try {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "/Telefonia/Get_Parameter",
            data: { Condition: "EstadoServicioTigo" },
            contentType: "application/json; charset=utf-8",
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('jqXHR:');
                console.log(jqXHR);
                console.log('textStatus:');
                console.log(textStatus);
                console.log('errorThrown:');
                console.log(errorThrown);
            },
            success: function (data) {
                Data = data;
                ServicioActivoTigo = Data[0].Valor;
            }

        });
    } catch (e) {
        console.log('Error Get_ParameterTigo ' + e)
    }
}

/*================================================================
          TRAE DE LOS PARAMETROS EL ESTADO DEL SERVICIO CLARO
  ================================================================*/
function Get_ParameterClaro() {
    try {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "/Telefonia/Get_Parameter",
            data: { Condition: "EstadoServicioClaro" },
            contentType: "application/json; charset=utf-8",
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('jqXHR:');
                console.log(jqXHR);
                console.log('textStatus:');
                console.log(textStatus);
                console.log('errorThrown:');
                console.log(errorThrown);
            },
            success: function (data) {
                Data = data;
                ServicioActivoClaro = Data[0].Valor;
            }
        });
    } catch (e) {
        console.log('Error Get_ParameterClaro ' + e)
    }
}

/*================================================================
      CONSULTA EL SALDO Y INICIALIZA LA GRAFICA DEL SALDO ACTUAL
  ================================================================*/
function Saldo_Proveedor() {
    try {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "/Telefonia/Saldo_Operador",
            data: { Fecha: Fecha.toISOString() },
            contentType: "application/json; charset=utf-8",
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('jqXHR:');
                console.log(jqXHR);
                console.log('textStatus:');
                console.log(textStatus);
                console.log('errorThrown:');
                console.log(errorThrown);
            },
            success: function (data) {
                console.log('saldo')
                console.log(data)
                Data = data;
                var total = parseInt(Data[0].Saldo_Inicial_TIGO, 10);
                var gastado = parseInt(Data[0].Saldo_Gastado_TIGO, 10);
                var Saldo_Claro = parseInt(Data[0].Saldo_Claro, 10)
                var Saldo_Tigo = parseInt(Data[0].Saldo_Tigo, 10)
                var actual = total - gastado;
                var Porcentaje = (actual * 100) / total;
                var TituloTigo;
                var Color1Tigo;
                var Color2Tigo;
                if (ServicioActivoTigo == 1) {
                    TituloTigo = "SALDO TIGO" + String.fromCharCode(9650);
                    Color1Claro = "#ef9a9a";
                    Color2Claro = "#c62828";
                } else if (ServicioActivoTigo == 0) {
                    TituloTigo = "SALDO CLARO" + String.fromCharCode(9660);
                    Color1Claro = "##ef9a9a";
                    Color2Claro = "##ef9a9a";
                }
                var config2 = {
                    type: 'bar',
                    data: {
                        labels: ["SALDO"],
                        datasets: [{
                            label: 'SALDO CLARO',
                            borderColor: "#e57373",
                            backgroundColor: '#e57373',
                            borderWidth: 2,
                            fill: true,
                            data: [Saldo_Claro]
                        }, {
                            label: 'SALDO TIGO',
                            borderColor: '#64b5f6',
                            backgroundColor: '#64b5f6',
                            borderWidth: 2,
                            fill: true,
                            data: [Saldo_Tigo]
                        }]
                    },
                    options: {
                        responsive: true,
                        maintainAspectRatio: true,
                        devicePixelRatio: 2,
                        title: {
                            display: true,
                            text: 'SALDO ACTUAL TELEFONIA'
                        },
                        tooltips: {
                            mode: 'index',
                            intersect: true
                        },
                        scales: {
                            yAxes: [{
                                ticks: {
                                    suggestedMin: 0,
                                    suggestedMax: 800000,
                                    max: parseInt(parseInt(Max_Saldo, 10) + 100000),
                                    min: 0,
                                    stepSize: 100000
                                }
                            }]
                        },
                        annotation: {
                            annotations: [{
                                type: 'line',
                                mode: 'horizontal',
                                scaleID: 'y-axis-0',
                                value: Max_Saldo,
                                borderColor: '#81c784',
                                borderWidth: 3,
                                label: {
                                    enabled: true,
                                    position: "right",
                                    fontSize: 12,
                                    content: 'Max'

                                }
                            },
                            {
                                type: 'line',
                                mode: 'horizontal',
                                scaleID: 'y-axis-0',
                                value: Min_Saldo,
                                borderColor: '#b71c1c',
                                borderWidth: 3,
                                label: {
                                    enabled: true,
                                    position: "right",
                                    fontSize: 12,
                                    content: 'Min'
                                }
                            },
                            {
                                type: 'line',
                                mode: 'horizontal',
                                scaleID: 'y-axis-0',
                                value: Med_Saldo,
                                borderColor: '#ffb74d',
                                borderWidth: 3,
                                label: {
                                    enabled: true,
                                    position: "right",
                                    fontSize: 12,
                                    content: 'Med'
                                }
                            }
                            ]
                        },
                    }
                };
                var ctx2 = document.getElementById('SaldoChart').getContext('2d');
                window.myLine = new Chart(ctx2, config2);
            }
        });
    } catch (e) {
        console.log('Error Saldo_Proveedor ' + e)
    }
}

/*================================================================
   EXTRAE LA DATA ENTRE FECHAS E INICIALIZA EL TRAZADO EN GRAFICA
             LINEAL DE LA PROYECCION DE LAS VENTAS
  ================================================================*/
function TrazaSaldo(DateIni, DateFinish, Type) {
    try {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "/Telefonia/Traza_Saldo",
            data: { FechaIni: DateIni, FechaFin: DateFinish, Tipo: Type },
            contentType: "application/json; charset=utf-8",
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('jqXHR:');
                console.log(jqXHR);
                console.log('textStatus:');
                console.log(textStatus);
                console.log('errorThrown:');
                console.log(errorThrown);
            },
            success: function (data) {
                Data = data;
                Saldo = data;
                var Dias = [];
                var Tigo = [];
                var Claro = [];
                var Todas = [];
                for (var i = 0; i < Data.length; i++) {
                    Dias.push(parseInt(Data[i].DIA, 10));
                    Tigo.push(parseInt(Data[i].SALDO_GASTADO_TIGO, 10));
                    Todas.push(parseInt(Data[i].SALDO_GASTADO_TIGO, 10));
                    Claro.push(parseInt(Data[i].SALDO_GASTADO_CLARO, 10) + parseInt(Data[i].SALDO_GASTADO_MOVISTAR, 10) + parseInt(Data[i].SALDO_GASTADO_TUENTI, 10));
                    Todas.push(parseInt(Data[i].SALDO_GASTADO_CLARO, 10) + parseInt(Data[i].SALDO_GASTADO_MOVISTAR, 10) + parseInt(Data[i].SALDO_GASTADO_TUENTI, 10));
                }
                var Mes = Fecha.getMonth();
                var Anio = Fecha.getFullYear();
                document.getElementById('TotalClaro')
                if (graficalineal != null) {
                    graficalineal.destroy();
                }
                graficalineal = new Chart(document.getElementById("GraficaLineal"), {
                    type: 'line',
                    showTooltips: false,
                    showInlineValues: true,
                    centeredInllineValues: true,
                    tooltipCaretSize: 0,
                    data: {
                        labels: Dias,
                        datasets: [
                            {
                                label: 'TIGO',
                                backgroundColor: "#64b5f6",
                                borderWidth: 2,
                                borderColor: "#64b5f6",
                                data: Tigo,
                                fill: false,
                                fontStyle: "bold",
                            },

                            {
                                label: 'CLARO',
                                fill: false,
                                backgroundColor: "#e57373",
                                borderWidth: 2,
                                borderColor: "#e57373",
                                data: Claro
                            }
                        ]
                    },
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                        devicePixelRatio: 2,
                        title: {
                            display: true,
                            text: 'SALDO VENDIDO' + Leyenda
                        },
                        tooltips: {
                            mode: 'index',
                            intersect: false,
                        },
                        scales: {
                            pointLabels: {
                                fontStyle: "bold",
                            }
                        }
                    }
                });
                var TotalTigo = 0;
                for (var i = 0; i < Tigo.length; i++) {
                    TotalTigo += Tigo[i];
                }
                document.getElementById('TotalTigo').innerHTML = TotalTigo;
                var TotalClaro = 0;
                for (var i = 0; i < Claro.length; i++) {
                    TotalClaro += Claro[i];
                }
                document.getElementById('TotalClaro').innerHTML = TotalClaro;
                Todas.sort(function (a, b) { return a - b });
                document.getElementById('recargas-max-vendido').innerHTML = Todas[Todas.length - 1];
                document.getElementById('recargas-min-vendido').innerHTML = Todas[0];
                graficalineal.resize(600, 600);

            }
        });
    } catch (e) {
        console.log(' Error TrazaSaldo ' + e)
    }
}

/*================================================================
           BUSCA LA INFORMACION SOLICITADA ENTRE FECHAS 
             Y GENERA UN REPORTE DESCARGABLE DE EXCEL
  ================================================================*/
function CrearExcel(DateIni, DateFinish) {
    try {
        if (DateIni.value != "") {
            if (DateIni.includes('/')) {
                if (DateFinish.value != "") {
                    if (DateFinish.includes('/')) {
                        var info;
                        $.ajax({
                            type: "GET",
                            dataType: "json",
                            url: "/Telefonia/Traza_Saldo",
                            data: { FechaIni: DateIni, FechaFin: DateFinish, Tipo: 2 },
                            contentType: "application/json; charset=utf-8",
                            error: function (jqXHR, textStatus, errorThrown) {
                                M.toast({ html: 'Ocurrio un error', classes: 'rounded black white-text' });
                                console.log('status code: ' + jqXHR.status + 'errorThrown: ' + errorThrown + 'jqXHR.responseText:' + jqXHR.responseText);
                                console.log('jqXHR:');
                                console.log(jqXHR);
                                console.log('textStatus:');
                                console.log(textStatus);
                                console.log('errorThrown:');
                                console.log(errorThrown);
                            },
                            success: function (Data) {
                                if (JSON.stringify(Data).includes('ERROR:') == false) {
                                    var Mes = Fecha.getMonth();
                                    var Anio = Fecha.getFullYear();
                                    try {
                                        var str = '';
                                        str += 'REPORTE DE VENTA DE RECARGAS' + Leyenda + '\r\n\n';
                                        str += 'NO.;PETICION; RESPUESTA;REFERENCIA;OPERADOR;SUCURSAL;ESTADO \r\n';
                                        for (var i = 0; i < Data.length; i++) {
                                            str += i + ';' + Data[i].FECHA_PETICION + ';' + Data[i].FECHA_RESPUESTA + ';' + Data[i].REFERENCIA + ';' + Data[i].OPERADOR + ';' + Data[i].SUCURSAL + ';' + Data[i].ESTADO + '\r\n';
                                        }
                                        var link = document.createElement("a");
                                        link.id = "lnkDwnldLnk";
                                        document.body.appendChild(link);
                                        var csv = str;
                                        blob = new Blob([csv], { type: 'text/csv' });
                                        var csvUrl = window.webkitURL.createObjectURL(blob);
                                        var filename = "SALDO VENDIDO DE " + DateIni + " A " + DateFinish + ".csv";
                                        $("#lnkDwnldLnk")
                                            .attr({
                                                'download': filename,
                                                'href': csvUrl
                                            });
                                        $('#lnkDwnldLnk')[0].click();
                                        document.body.removeChild(link);
                                    } catch (e) {
                                        alert(String(e));
                                    }
                                } else {
                                    console.log()
                                    M.toast({ html: Data[0].MENSAJE });
                                }
                            }
                        });
                    } else {
                        M.toast({ html: 'PorFavor Ingrese una Fecha Valida' });
                    }
                } else {
                    M.toast({ html: 'PorFavor Ingrese una Fecha Valida' });
                }
            } else {
                M.toast({ html: 'PorFavor Ingrese una Fecha Valida' });
            }
        } else {
            M.toast({ html: 'PorFavor Ingrese una Fecha Valida' });
        }
    } catch (e) {
        console.log('Error CrearExcel ' + e)
    }
}

/*===============================
   METODO PARA RECARGAR LA PAGINA
  ===============================*/
function Recargar() {
    location.reload();
}

/*================================================================
     CREA EL MODAL PARA CONFIGURAR EL LIMITE DE COMPRA DE SALDO
  ================================================================*/
function ModalSaldo(Type, Max, Med, Min) {
    try {
        var Modal = '';
        if (Type == 0) {

            Modal += '<div class="modal-content" style=" background-color: white;">';
            Modal += '<h4 id="TituloModal" style=" font-weight:700; color:#d50000; text-align:center;">CONFIGURAR LIMITES DE COMPRA DE SALDO</h4>';
            Modal += '<div class="divider"></div>';
            Modal += '<br />';
            Modal += '<br />';
            Modal += '<div class="row">';
            Modal += '<div class="col l4">';
            Modal += '<div class="row">';
            Modal += '<div class="" style="">';
            Modal += '<div class="resulted-content ">';
            Modal += '<h6 style="font-weight:700;">MAX</h6>';
            Modal += '<input type="number" id="max" class="validate">';
            Modal += '</div>';
            Modal += '</div>';
            Modal += '</div>';
            Modal += '<div class="row">';
            Modal += '<div class="">';
            Modal += '<div class="resulted-content ">';
            Modal += '<div class="resulted-content ">';
            Modal += '<h6 style="font-weight:700;">MED</h6>';
            Modal += '<input type="number" id="med" class="validate">';
            Modal += '</div>';
            Modal += '</div>';
            Modal += '</div>';
            Modal += '</div>';
            Modal += '<div class="row">';
            Modal += '<div class="">';
            Modal += '<div class="resulted-content ">';
            Modal += '<h6 style="font-weight:700;">MIN</h6>';
            Modal += '<input type="number" id="min" class="validate">';
            Modal += '</div>';
            Modal += '</div>';
            Modal += '</div>';
            Modal += '</div>';
            Modal += '<div class="col l8 " style="padding-top:1%">';
            Modal += '<canvas id="dividergrafica" class=" z-depth-2" ></canvas>';
            Modal += '</div>';
            Modal += '</div>';
            Modal += '</div>';
            Modal += '<div class="modal-footer" style="background-color:#1E317D">';
            Modal += '<a class="waves-effect waves-light btn modal-trigger z-depth-2 modal-close" style="font-weight:700;background-color:#00897B; margin-right:3px;" onclick="SaveLimiteSaldo()">GUARDAR</a>';
            Modal += '<a class="waves-effect waves-light btn modal-trigger z-depth-2 modal-close" style="font-weight:700;background-color:#00897B;">CERRAR</a>';
            Modal += '</div>';

            document.getElementById('Modal-Limite-Saldo').innerHTML = Modal

            document.getElementById('max').value = Max_Saldo;
            document.getElementById('med').value = Med_Saldo;
            document.getElementById('min').value = Min_Saldo;

            document.getElementById('max').addEventListener('input', updateValueMax);
            document.getElementById('med').addEventListener('input', updateValueMed);
            document.getElementById('min').addEventListener('input', updateValueMin);

            $.ajax({
                type: "GET",
                dataType: "json",
                url: "/Telefonia/Saldo_Operador",
                data: { Fecha: Fecha.toISOString() },
                contentType: "application/json; charset=utf-8",
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log('jqXHR:');
                    console.log(jqXHR);
                    console.log('textStatus:');
                    console.log(textStatus);
                    console.log('errorThrown:');
                    console.log(errorThrown);
                },
                success: function (data) {
                    Data = data;
                    var total = parseInt(Data[0].Saldo_Inicial_TIGO, 10);
                    var gastado = parseInt(Data[0].Saldo_Gastado_TIGO, 10);
                    var Saldo_Claro = parseInt(Data[0].Saldo_Claro, 10)
                    var Saldo_Tigo = parseInt(Data[0].Saldo_Tigo, 10)
                    var actual = total - gastado;
                    var Porcentaje = (actual * 100) / total;
                    var TituloTigo;
                    var Color1Tigo;
                    var Color2Tigo;
                    if (ServicioActivoTigo == 1) {
                        TituloTigo = "SALDO TIGO" + String.fromCharCode(9650);
                        Color1Claro = "#ef9a9a";
                        Color2Claro = "#c62828";
                    } else if (ServicioActivoTigo == 0) {
                        TituloTigo = "SALDO CLARO" + String.fromCharCode(9660);
                        Color1Claro = "##ef9a9a";
                        Color2Claro = "##ef9a9a";
                    }
                    var config2 = {
                        type: 'bar',
                        data: {
                            labels: ["SALDO"],
                            datasets: [{
                                label: 'SALDO CLARO',
                                borderColor: "#e57373",
                                backgroundColor: '#e57373',
                                borderWidth: 2,
                                fill: true,
                                data: [Saldo_Claro]
                            }, {
                                label: 'SALDO TIGO',
                                borderColor: '#64b5f6',
                                backgroundColor: '#64b5f6',
                                borderWidth: 2,
                                fill: true,
                                data: [Saldo_Tigo]
                            }]
                        },
                        options: {
                            responsive: true,
                            title: {
                                display: true,
                                text: 'SALDO ACTUAL TELEFONIA'
                            },
                            tooltips: {
                                mode: 'index',
                                intersect: true
                            },
                            scales: {
                                yAxes: [{
                                    ticks: {
                                        suggestedMin: 0,
                                        suggestedMax: 800000,
                                        max: parseInt(parseInt(Max_Saldo, 10) + 100000),
                                        min: 0,
                                        stepSize: 100000
                                    }
                                }]
                            },
                            annotation: {
                                annotations: [{
                                    type: 'line',
                                    mode: 'horizontal',
                                    scaleID: 'y-axis-0',
                                    value: Max_Saldo,
                                    borderColor: '#81c784',
                                    borderWidth: 3,
                                    label: {
                                        enabled: true,
                                        position: "right",
                                        fontSize: 12,
                                        content: 'Max'
                                    }
                                },
                                {
                                    type: 'line',
                                    mode: 'horizontal',
                                    scaleID: 'y-axis-0',
                                    value: Min_Saldo,
                                    borderColor: '#b71c1c',
                                    borderWidth: 3,
                                    label: {
                                        enabled: true,
                                        position: "right",
                                        fontSize: 12,
                                        content: 'Min'
                                    }
                                },
                                {
                                    type: 'line',
                                    mode: 'horizontal',
                                    scaleID: 'y-axis-0',
                                    value: Med_Saldo,
                                    borderColor: '#ffb74d',
                                    borderWidth: 3,
                                    label: {
                                        enabled: true,
                                        position: "right",
                                        fontSize: 12,
                                        content: 'Med'
                                    }
                                }
                                ]
                            },
                        }

                    };
                    var ctx2 = document.getElementById('dividergrafica').getContext('2d');
                    CacheModal = new Chart(ctx2, config2);
                }
            });
        }
        if (Type == 1) {
            if (CacheModal != null) {
                CacheModal.destroy();
            }
            var total = parseInt(Data[0].Saldo_Inicial_TIGO, 10);
            var gastado = parseInt(Data[0].Saldo_Gastado_TIGO, 10);
            var Saldo_Claro = parseInt(Data[0].Saldo_Claro, 10)
            var Saldo_Tigo = parseInt(Data[0].Saldo_Tigo, 10)
            var actual = total - gastado;
            var Porcentaje = (actual * 100) / total;
            var TituloTigo;
            var Color1Tigo;
            var Color2Tigo;
            if (ServicioActivoTigo == 1) {
                TituloTigo = "SALDO TIGO" + String.fromCharCode(9650);
                Color1Claro = "#ef9a9a";
                Color2Claro = "#c62828";
            } else if (ServicioActivoTigo == 0) {
                TituloTigo = "SALDO CLARO" + String.fromCharCode(9660);
                Color1Claro = "##ef9a9a";
                Color2Claro = "##ef9a9a";
            }
            var config2 = {
                type: 'bar',
                data: {
                    labels: ["SALDO"],
                    datasets: [{
                        label: 'SALDO CLARO',
                        borderColor: "#e57373",
                        backgroundColor: '#e57373',
                        borderWidth: 2,
                        fill: true,
                        data: [Saldo_Claro]
                    }, {
                        label: 'SALDO TIGO',
                        borderColor: '#64b5f6',
                        backgroundColor: '#64b5f6',
                        borderWidth: 2,
                        fill: true,
                        data: [Saldo_Tigo]
                    }]
                },
                options: {
                    responsive: true,
                    title: {
                        display: true,
                        text: 'SALDO ACTUAL TELEFONIA'
                    },
                    tooltips: {
                        mode: 'index',
                        intersect: true
                    },
                    scales: {
                        yAxes: [{
                            ticks: {
                                suggestedMin: 0,
                                suggestedMax: 800000,
                                max: parseInt(parseInt(Max, 10) + 100000),
                                min: 0,
                                stepSize: 100000
                            }
                        }]
                    },
                    annotation: {
                        annotations: [{
                            type: 'line',
                            mode: 'horizontal',
                            scaleID: 'y-axis-0',
                            value: Max,
                            borderColor: '#81c784',
                            borderWidth: 3,
                            label: {
                                enabled: true,
                                position: "right",
                                fontSize: 12,
                                content: 'Max'
                            }
                        },
                        {
                            type: 'line',
                            mode: 'horizontal',
                            scaleID: 'y-axis-0',
                            value: Min,
                            borderColor: '#b71c1c',
                            borderWidth: 3,
                            label: {
                                enabled: true,
                                position: "right",
                                fontSize: 12,
                                content: 'Min'
                            }
                        },
                        {
                            type: 'line',
                            mode: 'horizontal',
                            scaleID: 'y-axis-0',
                            value: Med,
                            borderColor: '#ffb74d',
                            borderWidth: 3,
                            label: {
                                enabled: true,
                                position: "right",
                                fontSize: 12,
                                content: 'Med'
                            }
                        }
                        ]
                    },
                }
            };
            var ctx2 = document.getElementById('dividergrafica').getContext('2d');
            CacheModal = new Chart(ctx2, config2);
        }
    } catch (e) {
        console.log('Error ModalSaldo ' + e)
    }
}


/*========================================================
                 EXTRAE LOS LIMITES ACTUALES 
           DE LOS PARAMETROS PARA COMPRA DE SALDO
  ========================================================*/
function getLimite() {
    try {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "/Telefonia/Get_Parameter",
            data: { Condition: 'MaxSaldo' },
            contentType: "application/json; charset=utf-8",
            error: function (jqXHR, textStatus, errorThrown) {
                console.log('jqXHR:');
                console.log(jqXHR);
                console.log('textStatus:');
                console.log(textStatus);
                console.log('errorThrown:');
                console.log(errorThrown);
            },
            success: function (data) {
                Max_Saldo = data[0].Valor;
                ModalMax = parseInt(data[0].Valor, 10)

                $.ajax({
                    type: "GET",
                    dataType: "json",
                    url: "/Telefonia/Get_Parameter",
                    data: { Condition: 'MedSaldo' },
                    contentType: "application/json; charset=utf-8",
                    error: function (jqXHR, textStatus, errorThrown) {
                        console.log('jqXHR:');
                        console.log(jqXHR);
                        console.log('textStatus:');
                        console.log(textStatus);
                        console.log('errorThrown:');
                        console.log(errorThrown);
                    },
                    success: function (data) {
                        Med_Saldo = data[0].Valor;
                        ModalMed = parseInt(data[0].Valor, 10)

                        $.ajax({
                            type: "GET",
                            dataType: "json",
                            url: "/Telefonia/Get_Parameter",
                            data: { Condition: 'MinSaldo' },
                            contentType: "application/json; charset=utf-8",
                            error: function (jqXHR, textStatus, errorThrown) {
                                console.log('jqXHR:');
                                console.log(jqXHR);
                                console.log('textStatus:');
                                console.log(textStatus);
                                console.log('errorThrown:');
                                console.log(errorThrown);
                            },
                            success: function (data) {
                                Min_Saldo = data[0].Valor;
                                ModalMin = parseInt(data[0].Valor, 10)
                                Saldo_Proveedor();
                            }
                        });
                    }
                });
            }
        });
    } catch (e) {
        console.log("Error getLimite " + e)
    }
}

/*=============================================================
   EVENTO QUE ESCUCHA LOS IMPUT DE EL MODAL DE LIMITE DE SALDO
  =============================================================*/

function updateValueMax(e) {

    ModalMax = parseInt(document.getElementById('max').value, 10);
    ModalSaldo(1, ModalMax, ModalMed, ModalMin)
}

function updateValueMed(e) {
    ModalMed = parseInt(document.getElementById('med').value, 10);
    ModalSaldo(1, ModalMax, ModalMed, ModalMin)
}

function updateValueMin(e) {
    ModalMin = parseInt(document.getElementById('min').value, 10);
    ModalSaldo(1, ModalMax, ModalMed, ModalMin)
}


/*=============================================================
                GUARDAR LIMITE DE COMPRA DE SALDO
  =============================================================*/

function SaveLimiteSaldo() {
    try {
        var V1 = parseInt(document.getElementById('max').value, 10);
        var V2 = parseInt(document.getElementById('med').value, 10);
        var V3 = parseInt(document.getElementById('min').value, 10);
        var V4 = parseInt(UserTelefonia);

        if (V1 > V2 && V1 > V3) {
            if (V2 < V1 && V2 > V3) {
                if (V3 < V2 && V3 < V1) {
                    if (V3 > 10000 && V2 > 10000 && V1 > 10000) {
                        $.ajax({
                            type: "GET",
                            dataType: "json",
                            url: "/Telefonia/Set_Limite_Compra",
                            data: { MAX: V1, MED: V2, MIN: V3, USER: V4 },
                            contentType: "application/json; charset=utf-8",
                            error: function (jqXHR, textStatus, errorThrown) {
                                M.toast({ html: 'Ocurrio un error', classes: 'rounded black white-text' });
                                console.log('jqXHR:');
                                console.log(jqXHR);
                                console.log('textStatus:');
                                console.log(textStatus);
                                console.log('errorThrown:');
                                console.log(errorThrown);
                            },
                            success: function (Data) {
                                //Recargar();
                                getLimite();
                                M.toast({ html: Data[0].MENSAJE });
                            }
                        });
                    } else {
                        M.toast({ html: 'CANTIDAD MINIMA 10,000' });
                    }
                } else {
                    M.toast({ html: 'EL LIMITE MINIMO DEBE SER MENOR AL MEDIO Y MENOR AL MAXIMO' });
                }
            } else {
                M.toast({ html: 'EL LIMITE MEDIO DEBE SER INTERMEDIO ENTRE EL MAXIMO Y MINIMO' });
            }
        } else {
            M.toast({ html: 'EL LIMITE MAXIMO DEBE SER MAYOR AL MEDIO' });
        }
    } catch (e) {
        console.log('Error SaveLimiteSaldo '+e)
    }
    



}

