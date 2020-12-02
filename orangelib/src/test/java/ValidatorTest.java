import org.junit.Assert;
import org.junit.Test;
import ru.orangedata.orangelib.models.Validator;

public class ValidatorTest {

    @Test
    public void testDateValidationSuccess() {
        Validator mock = new Validator() {
            @Override
            public String validate() {
                return checkDate("date", "2020-12-02 00:00:00", false);
            }
        };
        Assert.assertEquals("", mock.validate());
    }

    @Test
    public void testDateValidationError() {
        Validator mock = new Validator() {
            @Override
            public String validate() {
                return checkDate("date", "2020-12-02 00:00:00:33", false);
            }
        };
        Assert.assertNotEquals("", mock.validate());
    }

    @Test
    public void testStringSuccess() {
        Validator mock = new Validator() {
            @Override
            public String validate() {
                return check("string", "something", 9,9,false);
            }
        };
        Assert.assertEquals("", mock.validate());
    }

    @Test
    public void testStringRangeSuccess() {
        Validator mock = new Validator() {
            @Override
            public String validate() {
                return check("string", "something", 1,9,false);
            }
        };
        Assert.assertEquals("", mock.validate());
    }

    @Test
    public void testStringError() {
        Validator mock = new Validator() {
            @Override
            public String validate() {
                return check("string", "something", 1,5,false);
            }
        };
        Assert.assertNotEquals("", mock.validate());
    }

    @Test
    public void testDouble1Success() {
        Validator mock = new Validator() {
            @Override
            public String validate() {
                return check("double", 0.22, 2,false);
            }
        };
        Assert.assertEquals("", mock.validate());
    }

    @Test
    public void testDouble2Success() {
        Validator mock = new Validator() {
            @Override
            public String validate() {
                return check("double", 0.02, 2,false);
            }
        };
        Assert.assertEquals("", mock.validate());
    }

    @Test
    public void testDouble3Success() {
        Validator mock = new Validator() {
            @Override
            public String validate() {
                return check("double", 0.20, 2,false);
            }
        };
        Assert.assertEquals("", mock.validate());
    }

    @Test
    public void testDouble4Success() {
        Validator mock = new Validator() {
            @Override
            public String validate() {
                return check("double", 0.2, 2,false);
            }
        };
        Assert.assertEquals("", mock.validate());
    }

    @Test
    public void testDoubleError() {
        Validator mock = new Validator() {
            @Override
            public String validate() {
                return check("double", 0.222, 2,false);
            }
        };
        Assert.assertNotEquals("", mock.validate());
    }

    @Test
    public void testIntSuccess() {
        Validator mock = new Validator() {
            @Override
            public String validate() {
                return check("integer", 3, 1,5,false);
            }
        };
        Assert.assertEquals("", mock.validate());
    }

    @Test
    public void testIntError() {
        Validator mock = new Validator() {
            @Override
            public String validate() {
                return check("integer", 3, 1,2,false);
            }
        };
        Assert.assertNotEquals("", mock.validate());
    }

    @Test
    public void testNullableSuccess() {
        String n = null;
        Validator mock = new Validator() {
            @Override
            public String validate() {
                return check("integer", n, 1,5,true);
            }
        };
        Assert.assertEquals("", mock.validate());
    }

    @Test
    public void testNullableError() {
        String n = null;
        Validator mock = new Validator() {
            @Override
            public String validate() {
                return check("integer", n, 1,5,false);
            }
        };
        Assert.assertNotEquals("", mock.validate());
    }
}
