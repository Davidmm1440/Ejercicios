package ceu.dam.ad.apiExamenes.model;

import java.util.List;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_code")
@Table(name = "questions")
public abstract class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String text;
    
     //TODO: Por Hacer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_code", nullable = false, insertable = false, updatable = false)
    protected QuestionType type;
    
    @OneToMany
    @JoinColumn(name = "question_id", nullable = false)
    private List<Answer> answers;

    public abstract boolean validate();
}
