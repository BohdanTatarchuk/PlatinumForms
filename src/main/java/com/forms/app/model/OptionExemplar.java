package com.forms.app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "OptionExemplar")
public class OptionExemplar {

    @Id
    @Column(name = "option_id")
    private String optionId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "option_id", referencedColumnName = "option_id")
    private QuestionOption option;

    @Column(name = "answered")
    private boolean answered;

    public OptionExemplar() {}

    public OptionExemplar(QuestionOption option, boolean answered) {
        this.option = option;
        this.optionId = option.getId();
        this.answered = answered;
    }

    public QuestionOption getOption() {
        return option;
    }

    public void setOption(QuestionOption option) {
        this.option = option;
        this.optionId = option.getId();
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }
}
