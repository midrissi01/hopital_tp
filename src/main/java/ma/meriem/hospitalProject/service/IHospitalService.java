package ma.meriem.hospitalProject.service;

import ma.meriem.hospitalProject.entities.Consultation;
import ma.meriem.hospitalProject.entities.Medecin;
import ma.meriem.hospitalProject.entities.Patient;
import ma.meriem.hospitalProject.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
