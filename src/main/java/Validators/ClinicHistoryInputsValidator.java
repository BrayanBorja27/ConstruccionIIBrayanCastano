package Validators;

public class ClinicHistoryInputsValidator  extends InputsValidator{
    public void veterinarianValidator(String veterinarian) throws Exception {
        super.stringValidator(veterinarian, "Nombre de veterinario");
    }
    public void reasonForConsultationValidator(String reasonForConsultation) throws Exception {
        super.stringValidator(reasonForConsultation, "Motivo de consulta");
    }
    public void symptomsValidator(String symptoms) throws Exception {
        super.stringValidator(symptoms, "Sintomas");
    }

    public void diagnosticValidator(String diagnostic) throws Exception {
        super.stringValidator(diagnostic, "Diagnostico");
    }
    public void proceduresValidator(String procedures) throws Exception {
        super.stringValidator(procedures, " procedimiento");
    }
    public void medicinesValidator(String medicines) throws Exception {
        super.stringValidator(medicines, "Medicinas");
    }
    public long idOrderValidator(String idOrder) throws Exception {
        return super.longValidator(idOrder, " dueño de mascota");
    }
    public void vaccionationHistoryValidator(String vaccionationHistory) throws Exception {
        super.stringValidator(vaccionationHistory, " procedimiento");
    }
    public void allergiesValidator(String allergies) throws Exception {
        super.stringValidator(allergies, " procedimiento");
    }
    public void detailsProceduresValidator(String detailsProcedures) throws Exception {
        super.stringValidator(detailsProcedures, " procedimiento");
    }
}
