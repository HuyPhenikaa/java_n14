public class TreatmentRoom extends PatientList {
    private String name;

    public TreatmentRoom(String name) {
        super();
        this.name = name;
    }

    public TreatmentRoom() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void printNamePatient() {
        for (Patient patient : patientList) {
            System.out.println(patient.getName());
        }
    }

    public void showList() {
        System.out.println("Treatment room: " + getName());
        super.showList();
    }
}
