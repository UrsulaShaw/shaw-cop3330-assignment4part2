package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Ursula Shaw
 */

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String description;
    private LocalDate dueDate;
    private Boolean completionStatus;

    public Item(LocalDate dueDate, String itemDescription) {
        this.setDueDate(dueDate);
        this.setDescription(itemDescription);
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(Boolean completionStatus) {
        this.completionStatus = completionStatus;
    }

    @Override
    public String toString() {
        return "Due: " + this.getDueDate() + "\n" + this.getDescription();
    }

}
