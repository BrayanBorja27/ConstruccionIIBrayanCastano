package dto;

import java.sql.Date;

public class ClinicHistoryDto {
    private Date registerDate;

    private Long Admission;
    private PersonDto veterinarian;
    private String reasonForConsultation;
    private String symptoms;
    private String diagnostico;
    private String procedures;
    private String medicines;
    private OrderDto idOrder;
    private PetDto idPet;
    private String vaccinationHistory;
    private String allergies;
    private String detailsProcedures;
    private int estado = 0;
    private String medicationDosage;



    public ClinicHistoryDto( Long Admission,PersonDto veterinarian, String reasonForConsultation, String symptoms,String diagnostico, String procedures, String medicines, OrderDto idOrder,PetDto idPet, String vaccinationHistory, String allergies, String detailsProcedures) {

        this.veterinarian = veterinarian;
        this.Admission = Admission;
        this.reasonForConsultation = reasonForConsultation;
        this.symptoms = symptoms;
        this.diagnostico= diagnostico;
        this.procedures = procedures;
        this.medicines = medicines;
        this.idOrder = idOrder;
        this.idPet = idPet;
        this.vaccinationHistory = vaccinationHistory;
        this.allergies = allergies;
        this.detailsProcedures = detailsProcedures;
        this.registerDate= new Date(System.currentTimeMillis());
    }

    public ClinicHistoryDto(long actualDate, String veterinarian, String reasonForConsultation, String symptoms, String diagnostic, String procedures, String medicines, OrderDto orderDto, PetDto idPet, String vaccinationHistory, String allergies, String detailsProcedures) {
    }

    public String getMedicationDosage() {
        return medicationDosage;
    }

    public void setMedicationDosage(String medicationDosage) {
        this.medicationDosage = medicationDosage;
    }

    public int getEstado() {
        return estado;
    }

    public ClinicHistoryDto() {
        this.registerDate=new Date(System.currentTimeMillis());
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public Long getAdmission() {
        return Admission;
    }

    public void setAdmission(Long admission) {
        Admission = admission;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
    public PersonDto getVeterinarian() {
        return veterinarian;
    }
    public void setVeterinarian(PersonDto veterinarian) {
        this.veterinarian = veterinarian;
    }
    public String getReasonForConsultation() {
        return reasonForConsultation;
    }
    public void setReasonForConsultation(String reasonForConsultation) {
        this.reasonForConsultation = reasonForConsultation;
    }
    public String getSymptoms() {
        return symptoms;
    }
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getProcedures() {
        return procedures;
    }
    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }
    public String getMedicines() {
        return medicines;
    }
    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }
    public OrderDto getIdorder() {
        return idOrder;
    }
    public void setIdorder(OrderDto order) {
        this.idOrder = idOrder;
    }
    public String getVaccinationHistory() {
        return vaccinationHistory;
    }
    public void setVaccinationHistory(String vaccinationHistory) {
        this.vaccinationHistory = vaccinationHistory;
    }
    public String getAllergies() {
        return allergies;
    }
    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
    public String getDetailsProcedures() {
        return detailsProcedures;
    }
    public void setDetailsProcedures(String detailsProcedures) {
        this.detailsProcedures = detailsProcedures;
    }

    public OrderDto getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(OrderDto idOrder) {
        this.idOrder = idOrder;
    }

    public PetDto getIdPet() {
        return idPet;
    }

    public void setIdPet(PetDto idPet) {
        this.idPet = idPet;
    }



    public void showHistorys() {
        Date responseAdmissionsDate = new Date(this.Admission);
        System.out.println("==========================================");
        System.out.println(" Fecha de Ingreso: "+responseAdmissionsDate+
                "\n Id mascota: "+this.idPet.getIdNumber()+
                "\n Id Medico: "+this.getVeterinarian()+
                "\n Razon: "+this.reasonForConsultation+
                "\n Sitomatologia: "+this.symptoms+
                "\n Diagnosis: "+this.diagnostico+
                "\n Procedimiento: "+this.procedures+
                "\n Medicamento: "+this.medicines+
                "\n Dosis Medicamento: "+this.medicationDosage+
                "\n Id Orden: "+this.idOrder+
                "\n Historial de Vacunacion: "+this.vaccinationHistory+
                "\n Medicamentos Alergia: "+this.allergies+
                "\n Detalle de Procedimiento: "+this.detailsProcedures+
                "\n Orden cancelada: "+this.estado+"\n");
        System.out.println("==========================================");
    }
}
