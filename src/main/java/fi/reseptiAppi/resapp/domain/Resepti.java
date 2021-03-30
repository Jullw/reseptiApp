package fi.reseptiAppi.resapp.domain;

import javax.validation.constraints.NotNull;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.util.Base64Utils;

/**
 *
 * @author jsaja
 */



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resepti extends AbstractPersistable<Long> {

    // AutoGeneroi ID:en
    
    @NotNull
    @Size(min=3,max=50)
    private String reseptinNimi;
    
    
    @Size(min=3,max=20)
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
