package doctor.management;

import java.util.*;

public class DoctorManagement {
    private List<Doctor> doctors;

    public DoctorManagement() {
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void deleteDoctorById(String id) {
        Doctor doctor = getDoctorById(id);
        if (doctor != null) {
            doctors.remove(doctor);
        } else {
            System.out.println("Doctor not found.");
        }
    }

    public void updateDoctor(Doctor updatedDoctor) {
        Doctor doctor = getDoctorById(updatedDoctor.getId());
        if (doctor != null) {
            int index = doctors.indexOf(doctor);
            doctors.set(index, updatedDoctor);
        } else {
            System.out.println("Doctor not found.");
        }
    }
    
    public List<Doctor> getDoctors() {
        return new ArrayList<>(doctors);
    }

    public Doctor getDoctorById(String id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }
        return null;
    }

    public List<Doctor> searchDoctors(String searchString) {
        List<Doctor> results = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getName().contains(searchString) || doctor.getSpecialization().contains(searchString)) {
                results.add(doctor);
            }
        }
        return results;
    }

//    public void displayDoctors() {
//        if (doctors.isEmpty()) {
//            System.out.println("No doctors found.");
//        } else {
//            System.out.println("Doctors:");
//            for (Doctor doctor : doctors) {
//                System.out.println(doctor);
//            }
//        }
//    }
}
