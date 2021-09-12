package Return;

import java.time.LocalDate;

public class Return {


    private LocalDate dateOfReturn;


    public Return() {
        this.dateOfReturn = LocalDate.now();
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}
