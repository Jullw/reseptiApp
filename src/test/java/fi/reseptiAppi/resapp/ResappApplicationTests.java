package fi.reseptiAppi.resapp;

import fi.reseptiAppi.resapp.domain.Resepti;
import fi.reseptiAppi.resapp.domain.ReseptiRepository;
import fi.reseptiAppi.resapp.web.LuoReseptiController;
import fi.reseptiAppi.resapp.web.RestReseptiController;
import fi.reseptiAppi.resapp.web.etusivuController;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ResappApplicationTests {

    @Autowired
    private etusivuController etusivucontroller;
    @Autowired
    private LuoReseptiController luocontroller;
    @Autowired
    private RestReseptiController restResepticontroller;
    @Autowired
    private ReseptiRepository ree;

    @Test
    void contextLoads() throws Exception {
        assertThat(etusivucontroller).isNotNull();
        assertThat(luocontroller).isNotNull();
        assertThat(restResepticontroller).isNotNull();
    }

    @Test
    public void luoUusiResepti() {
        Resepti re = new Resepti();

        ree.save(re);
        assertThat(re.getId()).isNotNull();
    }
}
    /*assertThat(”Hello World”).contains(”Hello”)
assertThat(objectToTest).isNotNull();
assertThat(person.getName()).startsWith(”M”).endWith(”s”); */
