package model;

public class Human {
    private Long age; //Значение поля должно быть больше 0

    public Human(Long age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "age=" + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Human) {
            if (this.getAge().equals(((Human) obj).getAge())) {return true;}
            return false;
        } else {return false;}
    }

    public Long getAge() {
        return age;
    }
}