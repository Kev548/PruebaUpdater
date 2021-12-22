

// url a la cual redirigirá al validar un login correcto
let home = "/Telefonia/Index";
let User;

$(document).ready(function () {
    $("#ContenedorLogin").fadeIn("slow");
});

$(document).ready(function () {
    sessionStorage.clear();
    $("#ContenedorLogin").fadeIn("slow");
    setEnterKeyListener("txtPas", "btnLogin");
    setEnterKeyListener("txtUsr", "btnLogin");
    $("#txtUsr").focus();

   


});

function setEnterKeyListener(elementId, buttonId) {
    try {
        var input = document.getElementById(elementId);
        input.addEventListener("keyup", function (event) {
            if (event.keyCode === 13) {
                event.preventDefault();
                document.getElementById(buttonId).click();
            }
        });
    } catch (e) {

    }

}

$('#btnLogin').click(function () {

    GetLogin();

});

function GetLogin() {


    /***************************************************/
    /* this method verifies that the user exists in DB */
    /***************************************************/


    if (!document.getElementById("txtUsr").value
        || !document.getElementById("txtPas").value) {
        M.toast({ html: '<b>Ingresa un usuario y contraseña.<b>' });
        return;
    }

    var vUser = document.getElementById("txtUsr").value;
    var vPassword = document.getElementById("txtPas").value;
    localStorage.setItem("UsuarioLogged", document.getElementById("txtUsr").value);

    var parametros = {
        usrid: vUser,
        pas: vPassword
    };

    $.ajax({
        url: '/Login/Autenticar',
        type: 'POST',
        dataType: 'json',
        data: JSON.stringify(parametros),
        contentType: 'application/json; charset=utf-8',
        error: function (resultado) {
            /* Error al realizar la consulta*/
            M.toast({ html: '<b>Ha ocurrido un error.<b>' });
        },
        success: function (result) {
            if (String(result) == '1') {
                sessionStorage.setItem("usrid", String(result));
                window.location.href = home;


            } else {
                /* Error validando usuario */
                M.toast({ html: '<b>Usuario / Contraseña inválidos.<b>' });
                incorrectUser();
            }
        }
    });
}

function incorrectUser() {
    document.getElementById('txtPas').value = "";
    document.getElementById('txtUsr').value = "";
}

function Leave() {
    $.ajax({
        type: "GET",
        url: "/Login/Leave",
        error: function (jqXHR, textStatus, errorThrown) {
            M.toast({ html: 'Ocurrio un error', classes: 'rounded black white-text' });


            ('jqXHR:');
            console.log(jqXHR);
            console.log('textStatus:');
            console.log(textStatus);
            console.log('errorThrown:');




            (errorThrown);
        },
        success: function () {
            location.reload();
        }
    });
}

