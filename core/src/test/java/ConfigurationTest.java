import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/applicationContext-core.xml")
public class ConfigurationTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void testInjectEntityManager() throws Exception {
        assertNotNull("Could not inject entity manager dependency", entityManager);

    }
}
