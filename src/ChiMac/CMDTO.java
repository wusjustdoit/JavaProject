package ChiMac;

public class CMDTO {

	// 회원가입 정보 필드
	private String cmId;
	private String cmPw;
	private String cmName;
	private String cmBir;
	private String cmGen;
	private String cmEmail;
	private String cmAdr;
	private String cmPhone;
	private int cmBalance;
	private String cmMenu;
	private String cmReview;
	private int cmReviewNo;
	
	
	
	// getter, setter
	public int getCmReviewNo() {
		return cmReviewNo;
	}
	public void setCmReviewNo(int cmReviewNo) {
		this.cmReviewNo = cmReviewNo;
	}
	public String getCmMenu() {
		return cmMenu;
	}
	public void setCmMenu(String cmMenu) {
		this.cmMenu = cmMenu;
	}
	public String getCmReview() {
		return cmReview;
	}
	public void setCmReview(String cmReview) {
		this.cmReview = cmReview;
	}
	public String getCmId() {
		return cmId;
	}
	public void setCmId(String cmId) {
		this.cmId = cmId;
	}
	public String getCmPw() {
		return cmPw;
	}
	public void setCmPw(String cmPw) {
		this.cmPw = cmPw;
	}
	public String getCmName() {
		return cmName;
	}
	public void setCmName(String cmName) {
		this.cmName = cmName;
	}
	public String getCmBir() {
		return cmBir;
	}
	public void setCmBir(String cmBir) {
		this.cmBir = cmBir;
	}
	public String getCmGen() {
		return cmGen;
	}
	public void setCmGen(String cmGen) {
		this.cmGen = cmGen;
	}
	public String getCmEmail() {
		return cmEmail;
	}
	public void setCmEmail(String cmEmail) {
		this.cmEmail = cmEmail;
	}
	public String getCmAdr() {
		return cmAdr;
	}
	public void setCmAdr(String cmAdr) {
		this.cmAdr = cmAdr;
	}
	public String getCmPhone() {
		return cmPhone;
	}
	public void setCmPhone(String cmPhone) {
		this.cmPhone = cmPhone;
	}
	
	public int getCmBalance() {
		return cmBalance;
	}
	public void setCmBalance(int cmBalance) {
		this.cmBalance = cmBalance;
	}
	


	
	
	// toString
	@Override
	public String toString() {
		return "CMDTO [cmId=" + cmId + ", cmPw=" + cmPw + ", cmName=" + cmName + ", cmBir=" + cmBir + ", cmGen="
				+ cmGen + ", cmEmail=" + cmEmail + ", cmAdr=" + cmAdr + ", cmPhone=" + cmPhone + ", cmBalance=" + cmBalance + ", cmMenu=" + cmMenu + ", cmReview=" + cmReview + ", cmReviewNo="
				+ cmReviewNo + "]";
	}
	
	


	// 기본 생성자
	public CMDTO() {
	}
	
	
	
	// 매개변수 생성자
	public CMDTO(String cmId, String cmPw, String cmName, String cmBir, String cmGen, String cmEmail, String cmAdr,
			String cmPhone, int cmBalance, String cmMenu, String cmReview, int cmReviewNo) {
		super();
		this.cmId = cmId;
		this.cmPw = cmPw;
		this.cmName = cmName;
		this.cmBir = cmBir;
		this.cmGen = cmGen;
		this.cmEmail = cmEmail;
		this.cmAdr = cmAdr;
		this.cmPhone = cmPhone;
		this.cmBalance = cmBalance;
		this.cmMenu = cmMenu;
		this.cmReview = cmReview;
		this.cmReviewNo = cmReviewNo;
	}

	
	
	
	
}





