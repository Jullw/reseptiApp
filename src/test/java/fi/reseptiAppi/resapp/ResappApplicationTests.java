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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ResappApplicationTests {

    @Autowired
    private etusivuController etusivucontroller;
    @Autowired
    private LuoReseptiController luocontroller;
    @Autowired
    private RestReseptiController restResepticontroller;
    @Autowired
    private ReseptiRepository ReseptiRepository;
    @Autowired
    private MockMvc mockMvc;

    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new etusivuController()).build();
    }

    @Test
    public void testHomePage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("etusivu"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    void contextLoads() throws Exception {
        assertThat(etusivucontroller).isNotNull();
        assertThat(luocontroller).isNotNull();
        assertThat(restResepticontroller).isNotNull();
    }

    @Test
    public void luoUusiResepti() {
        Resepti re = new Resepti();

        re.setReseptinNimi("Puuro"); // muuten validointi error, koska ei saa olla null eikä alle kolme kirjainta;
        re.setValmistusOhje("Keita vesi");
        re.setRuokalaji("aamupala");
        ReseptiRepository.save(re);
        assertThat(re.getId()).isNotNull();
    }
}
