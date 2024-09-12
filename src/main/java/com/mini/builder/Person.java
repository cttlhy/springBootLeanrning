package com.mini.builder;

class Person {
    private String name;
    private String sex;
    private Integer age;
    private String address;

    private Person(PersonBuilder personBuilder){
        this.name = personBuilder.name;
        this.address = personBuilder.address;
        this.sex = personBuilder.sex;
        this.age = personBuilder.age;
    }

    public static class PersonBuilder {
        private String name;
        private String sex;
        private Integer age;
        private String address;

        public PersonBuilder(String name,String sex){
            this.name = name;
            this.sex = sex;
        }

        public PersonBuilder setAge(Integer age){
            this.age = age;
            return this;
        }

        public PersonBuilder setAddress(String address){
            this.address = address;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
