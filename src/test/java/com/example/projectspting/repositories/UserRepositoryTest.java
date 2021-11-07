package com.example.projectspting.repositories;

import com.example.projectspting.entities.Utilisateur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void TestMock() {
        String a = mock(String.class);
// using mock object - it does not throw any "unexpected interaction" exception
        System.out.println(a);
    }

    @Test
    public void shouldSaveUserTest() {
        Utilisateur u = Utilisateur.builder().nom("chiheb")
                .email("chiheb.rabeh@gmail.com").build();
        Utilisateur utilisateur = userRepository.save(u);
        Assertions.assertNotNull(utilisateur);
    }

    @Test
    public void canFindUtilisateurByName() {
        Set<Utilisateur> utilisateur = this.userRepository.findUtilisateurByNom("chiheb");
        Assertions.assertNotNull(utilisateur);
        assertThat(utilisateur.size()).isNotEqualTo(0);
    }

    @Test
    public void canUpdateUtilisateur() {
        Set<Utilisateur> utilisateur = this.userRepository.findUtilisateurByNom("chiheb");
        Assertions.assertNotNull(utilisateur);
        assertThat(utilisateur.size()).isNotEqualTo(0);
    }

    @Test
    public void canDeleteUtilisateur() {
        Set<Utilisateur> utilisateurs = this.userRepository.findUtilisateurByNom("chiheb");
        this.userRepository.deleteAll(utilisateurs);
        Assertions.assertEquals(userRepository.findAll().size(), 1);
        //assertThat(utilisateur.size()).isNotEqualTo(0);
    }


}
