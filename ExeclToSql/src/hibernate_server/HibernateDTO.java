package hibernate_server;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HibernateDTO {
	@Id
	int Sno;
	int ConstituencyNo;
	String ConstituencyName;
	String CandidateName;
	String CandidateSex;
	int CandidateAge;
	String CandidateCategory;
	String PartyName;
	int ValidVotesGeneral;
	int ValidVotesPostal;
	int TotalValidVotes;
	int TotalElectors;
	int TotalVVPNOTA;
	double Pvotespolled;
	public int getSno() {
		return Sno;
	}
	public void setSno(int sno) {
		Sno = sno;
	}
	public int getConstituencyNo() {
		return ConstituencyNo;
	}
	public void setConstituencyNo(int constituencyNo) {
		ConstituencyNo = constituencyNo;
	}
	public String getConstituencyName() {
		return ConstituencyName;
	}
	public void setConstituencyName(String constituencyName) {
		ConstituencyName = constituencyName;
	}
	public String getCandidateName() {
		return CandidateName;
	}
	public void setCandidateName(String candidateName) {
		CandidateName = candidateName;
	}
	public String getCandidateSex() {
		return CandidateSex;
	}
	public void setCandidateSex(String candidateSex) {
		CandidateSex = candidateSex;
	}
	public int getCandidateAge() {
		return CandidateAge;
	}
	public void setCandidateAge(int candidateAge2) {
		CandidateAge = candidateAge2;
	}
	public String getCandidateCategory() {
		return CandidateCategory;
	}
	public void setCandidateCategory(String candidateCategory) {
		CandidateCategory = candidateCategory;
	}
	public String getPartyName() {
		return PartyName;
	}
	public void setPartyName(String partyName) {
		PartyName = partyName;
	}
	public int getValidVotesGeneral() {
		return ValidVotesGeneral;
	}
	public void setValidVotesGeneral(int validVotesGeneral) {
		ValidVotesGeneral = validVotesGeneral;
	}
	public int getValidVotesPostal() {
		return ValidVotesPostal;
	}
	public void setValidVotesPostal(int validVotesPostal) {
		ValidVotesPostal = validVotesPostal;
	}
	public int getTotalValidVotes() {
		return TotalValidVotes;
	}
	public void setTotalValidVotes(int totalValidVotes) {
		TotalValidVotes = totalValidVotes;
	}
	public int getTotalElectors() {
		return TotalElectors;
	}
	public void setTotalElectors(int totalElectors) {
		TotalElectors = totalElectors;
	}
	public int getTotalVVPNOTA() {
		return TotalVVPNOTA;
	}
	public void setTotalVVPNOTA(int totalVVPNOTA) {
		TotalVVPNOTA = totalVVPNOTA;
	}
	public double getPvotespolled() {
		return Pvotespolled;
	}
	public void setPvotespolled(double pvotespolled) {
		Pvotespolled = pvotespolled;
	}
	
}
