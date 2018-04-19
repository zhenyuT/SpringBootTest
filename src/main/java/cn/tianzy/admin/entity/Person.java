package cn.tianzy.admin.entity;

public class Person {
    private String name;
    private Integer age;

    public static void main(String[] args) {
        Person p = Person.newBuilder()
                .name("tianzy")
                .age(20)
                .build();
        System.out.println(p.getName());
        System.out.println(p.getAge());
    }

    private Person(Builder builder) {
        setName(builder.name);
        setAge(builder.age);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Person copy) {
        Builder builder = new Builder();
        builder.name = copy.getName();
        builder.age = copy.getAge();
        return builder;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public static final class Builder {
        private String name;
        private Integer age;

        private Builder() {
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder age(Integer val) {
            age = val;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
