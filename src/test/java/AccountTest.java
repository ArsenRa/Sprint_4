import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class AccountTest {
    private Account account;
    private String name;
    private Boolean result;

    public AccountTest(String name,Boolean result){
        this.name = name;
        this.result = result;
    }

    @Before
    public void setUp(){
        account = new Account(name);
    }

    @Parameterized.Parameters(name = "{index}: для имени: {0} метод checkNameToEmboss возвращает {1} ")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {"Шимоми Талатэ",true},
                        {"Шимоми Талатэ  ",false},
                        {"  Шимоми Талатэ",false},
                        {"Шимоми  Талатэ",false},
                        {" ШимомиТалатэ",false},
                        {"ШимомиТалатэ ",false},
                        {"Ш Т",true},
                        {"ШТ",false},
                        {"Шимоми Талатэававпдлолвпва",false},
                        {"Шимоми Талатэтэтээ",true},
                        {null,false}
        }
        );
    }

    @Test
    public void checkNameTest() {
        boolean valid = account.checkNameToEmboss();
        assertEquals(result,valid);
    }

}
