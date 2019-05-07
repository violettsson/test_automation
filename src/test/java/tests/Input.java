package tests;

import core.model.Credentials;
import core.model.Employee;

public class Input {

    public static class employees {

        public static Employee standard = new Employee("Johan", "Cruijf","2014-03-26", "test@email.com" );

        public static Employee alter = new Employee("Jari", "Litmanen","2014-03-26", "test@email.com" );

        public static Employee emptyFirstNameDetails = new Employee("","Cruijf","2019-01-11", "test@email.com" );

        public static Employee invalidEmailDetails = new Employee("Johan","Cruijf","2014-03-26", "email.com" );
    }

    public static class credentials {

        public static Credentials valid = new Credentials("Luke", "Skywalker");

        public static Credentials invalid = new Credentials("Lukes", "Skywalker");

        public static Credentials empty = new Credentials("", "");
    }
}
