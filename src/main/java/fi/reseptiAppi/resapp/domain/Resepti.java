package fi.reseptiAppi.resapp.domain;

import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jsaja
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resepti{
    /**********************************/
    /*ID:en autogenerointi abstractluokalla, loi aina uuden tietokanta objectin sen takia ei pystynyt muokkaamaan resepteja*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    /**********************************/

    @NotNull // Validointi 
    @Size(min = 3, max = 50)
    private String reseptinNimi;

    @Size(min = 3, max = 20)
    private String ruokalaji;

    private int annosKoko;
    private int valmistusAika;

    @NotNull
    private String valmistusOhje;

    private String vaikeusTaso; //Selectilla thymessa */

    // private int tykkaykset;  // Laske näiden ratio Kontrollissa hae "SQL" lausekkaalla
    // private int epäTykkäykset;
    // private String kuvaOsoite;
    /*  @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] kuva; */
    //@ManyToMany
    private String aineOsat;

    //   private byte[] kuva64;
    /*    @Lob
     private String sKuva64; */
 /*         this.kuva64 = Base64Utils.encode(kuva);
        System.out.println(new String(this.kuva64));    */
 /* public void setKuva(byte[] kuva){
        this.sKuva64 = Base64Utils.encodeToString(kuva );
        this.kuva = kuva;
    } */
}
