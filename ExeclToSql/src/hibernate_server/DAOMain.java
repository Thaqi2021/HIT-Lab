package hibernate_server;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate_client.ReadExcel;

public class DAOMain {

	Configuration cfg ;
	SessionFactory factory ;
	Session session;
	public DAOMain() {
		cfg =new Configuration().configure("hibernate.anno.cfg.xml");
		
		factory = cfg.buildSessionFactory();
		
		session = factory.openSession();
	}
	public void DAOMained(int sno, int constituencyNo, String constituencyName, String candidateName, String candidateSex,
			int candidateAge, String candidateCategory, String partyName, int validVotesGeneral,
			int validVotesPostal, int totalValidVotes, int totalElectors, int totalVVPNOTA, double pvotespolled) {
		
		

		HibernateDTO dto = new HibernateDTO();
		
		dto.setSno(sno);
		dto.setConstituencyNo(constituencyNo);
		dto.setConstituencyName(constituencyName);
		dto.setCandidateName(candidateName);
		dto.setCandidateSex(candidateSex);
		dto.setCandidateAge(candidateAge);
		dto.setCandidateCategory(candidateCategory);
		dto.setPartyName(partyName);
		dto.setValidVotesGeneral(validVotesGeneral);
		dto.setValidVotesPostal(validVotesPostal);
		dto.setTotalValidVotes(totalValidVotes);
		dto.setTotalElectors(totalElectors);
		dto.setTotalVVPNOTA(totalVVPNOTA);
		dto.setPvotespolled(pvotespolled);
		Transaction tx=session.beginTransaction();//		session.beginTransaction().commit();

		session.save(dto);
		
		tx.commit();

	}
	
}
