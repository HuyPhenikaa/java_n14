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

    public int getNumberOfPatient() {
        return patientList.size();
    }

    public void getInformation(String[] name, int[] id, int[] age, int[] dayOfBirth, int[] monthOfBirth,
            int[] yearOfBirth, String[] nameOfTreatmentroom, String[] nameOfIllness, String[] note, int[] dayOfIn,
            int[] monthOfIn, int[] yearOfIn, int[] dayOfOut, int[] monthOfOut, int[] yearOfOut, int i) {
        for (Patient patient : patientList) {
            name[i] = patient.getName();
            id[i] = patient.getID();
            age[i] = patient.getAge();
            dayOfBirth[i] = patient.getDayOfBirth();
            monthOfBirth[i] = patient.getMonthOfBirth();
            yearOfBirth[i] = patient.getYearOfBirth();
            nameOfTreatmentroom[i] = patient.getTreatmentRoom();
            nameOfIllness[i] = patient.getIllness();
            note[i] = patient.getNote();
            dayOfIn[i] = patient.getDayOfIn();
            monthOfIn[i] = patient.getMonthOfIn();
            yearOfIn[i] = patient.getYearOfIn();
            dayOfOut[i] = patient.getDayOfOut();
            monthOfOut[i] = patient.getMonthOfOut();
            yearOfOut[i] = patient.getYearOfOut();
            i = i + 1;
        }
    }
}
