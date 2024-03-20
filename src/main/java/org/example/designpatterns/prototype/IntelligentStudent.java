package org.example.designpatterns.prototype;

public class IntelligentStudent extends Student {
    public int iq;

    public IntelligentStudent(IntelligentStudent student) {
        super(student);
        this.iq = student.iq;
    }

    public IntelligentStudent() {

    }

    @Override
    public Student clone() {
        return new IntelligentStudent(this);
    }
}
