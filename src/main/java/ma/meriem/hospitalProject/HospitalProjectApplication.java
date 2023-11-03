package ma.meriem.hospitalProject;

import ma.meriem.hospitalProject.entities.*;
import ma.meriem.hospitalProject.repositories.ConsultationRepository;
import ma.meriem.hospitalProject.repositories.MedecinRepository;
import ma.meriem.hospitalProject.repositories.PatientRepository;
import ma.meriem.hospitalProject.repositories.RendezVousRepository;
import ma.meriem.hospitalProject.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
class HospitalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalProjectApplication.class,args);
	}
	@Bean
	CommandLineRunner start(IHospitalService hospitalService,
							PatientRepository patientRepository,
							MedecinRepository medecinRepository,
							ConsultationRepository consultationRepository,
							RendezVousRepository rendezVousRepository){
		return args -> {
			Stream.of("Mohamed","Meriem","Hassan")
					.forEach(name->{
						Patient patient=new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						hospitalService.savePatient(patient);
					});
			Stream.of("khadija","ilhame","fatima-ezzahra")
					.forEach(name-> {
						Medecin medecin = new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name + "@gamil.com");
						medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
						hospitalService.saveMedecin(medecin);
					});
			Patient patient=patientRepository.findByNom("Meriem");
			Patient patient1=patientRepository.findById(1L).orElse(null);
			Medecin medecin=medecinRepository.findByNom("khadija");
			RendezVous rendezVous=new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setPatient(patient);
			rendezVous.setMedecin(medecin);
			RendezVous saveRDV = hospitalService.saveRendezVous(rendezVous);
			System.out.println(saveRDV.getId());
			hospitalService.saveRendezVous(rendezVous);
			RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
			Consultation consultation=new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de consultation");
			hospitalService.saveConsultation(consultation);


		};

	}
}
