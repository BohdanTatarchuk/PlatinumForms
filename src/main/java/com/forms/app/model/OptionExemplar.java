package com.forms.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "OptionExemplar")
public class OptionExemplar {
    @Column(name= "answered")
    private boolean answered;

    @Id
    @OneToOne
    @JoinColumn(name = "option_id", referencedColumnName = "option_id")
    private QuestionOption option;

    public OptionExemplar() {}

    public OptionExemplar(QuestionOption option, boolean answered) {
        this.option = option;
        this.answered = answered;
    }

    public QuestionOption getOption() {
        return option;
    }

    public void setOption(QuestionOption option) {
        this.option = option;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }
}
