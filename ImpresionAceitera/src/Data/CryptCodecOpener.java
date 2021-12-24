/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Kevin
 */
import java.io.File;
import java.io.IOException;
import net.ucanaccess.jdbc.JackcessOpenerInterf­ace;
import com.healthmarketscience.jackcess.CryptCo­decProvider;
import com.healthmarketscience.jackcess.Databas­e;
import com.healthmarketscience.jackcess.Databas­eBuilder;
import com.healthmarketscience.jackcess.impl.CodecProvider;

public class CryptCodecOpener implements JackcessOpenerInterface {

    @Override
    public Database open(File fl, String pwd) throws IOException {
        DatabaseBuilder dbd = new DatabaseBuilder(fl);
        dbd.setAutoSync(false);
        dbd.setCodecProvider((CodecProvider) new CryptCodecProvider(pwd));
        dbd.setReadOnly(false);
        return dbd.open();
    }
}
