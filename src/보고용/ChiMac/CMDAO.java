package ChiMac;

import java.sql.*;

public class CMDAO {
	// DB접속을 위한 변수 선언
	Connection conn = null;
		
	// 쿼리문 전송을 위한 변수 선언
	PreparedStatement pstmt = null;
		
	// 조회결과를 저장하기 위한 변수 선언
	ResultSet rs = null;
	
	
	// connect()메소드
	public void connect() {
		conn = DBC.DBConnect();
	}

	// conClose()메소드
	public void conClose() {
		try {
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	
	// 로그인 idCheck()메소드
	public boolean idCheck(String cId, String cPw) {
		String sql = "SELECT CMID FROM CHIMAC WHERE CMID =? AND CMPW =?";
		
		boolean checkResult = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cId);
			pstmt.setString(2, cPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				checkResult = true;
			} else {
				checkResult = false;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return checkResult;
	} // end idCheck()
	
	
	// 회원가입 memberJoin()메소드
	public void memberJoin(CMDTO chimac) {
		String sql = "INSERT INTO CHIMAC VALUES(?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1 ,chimac.getCmId());
			pstmt.setString(2 ,chimac.getCmPw());
			pstmt.setString(3 ,chimac.getCmName());
			pstmt.setString(4 ,chimac.getCmBir());
			pstmt.setString(5 ,chimac.getCmGen());
			pstmt.setString(6 ,chimac.getCmEmail());
			pstmt.setString(7 ,chimac.getCmAdr());
			pstmt.setString(8 ,chimac.getCmPhone());
			pstmt.setInt(9 ,chimac.getCmBalance());

			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("회원가입 성공!");
			} else {
				System.out.println("회원가입 실패!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

	} // end memberJoin()

	
	// 회원수정 memberModify()메소드
	public void memberModify(CMDTO chimac) {
		String sql = "UPDATE CHIMAC SET CMPW=?, CMNAME=?, CMBIR=?, CMGEN=?, "
				+ "CMEMAIL=?, CMADR=?, CMPHONE=? WHERE CMID=? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, chimac.getCmPw());
			pstmt.setString(2, chimac.getCmName());
			pstmt.setString(3, chimac.getCmBir());
			pstmt.setString(4, chimac.getCmGen());
			pstmt.setString(5, chimac.getCmEmail());
			pstmt.setString(6, chimac.getCmAdr());
			pstmt.setString(7, chimac.getCmPhone());
			pstmt.setString(8, chimac.getCmId());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("회원 정보 수정 성공!");
			} else {
				System.out.println("회원 정보 수정 실패!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	} // end memberModify()

	
	// 회원조회 memberList()메소드
	public void memberList(String cId) {
		String sql = "SELECT * FROM CHIMAC WHERE CMID=? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("아이디 : " + rs.getString(1));
				System.out.println("비밀번호 : " + rs.getString(2));
				System.out.println("이름 : " + rs.getString(3));
				System.out.println("생년월일 : " + rs.getString(4));
				System.out.println("성별 : " + rs.getString(5));
				System.out.println("이메일 : " + rs.getString(6));
				System.out.println("주소 : " + rs.getString(7));
				System.out.println("전화번호 : " + rs.getString(8));
				System.out.println("예금잔액 : " + rs.getInt(9));
			} 
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	} // end memberModify()

	
	// 회원탈퇴 memberDelete()메소드
	public void memberDelete(String cId) {
		String sql = "DELETE CHIMAC WHERE CMID=? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cId );
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("회원정보 삭제 성공!");
			} else {
				System.out.println("회원정보 삭제 실패!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	} // end memberDelete()

	public void deposit(CMDTO chimac) { // 입금 메소드
		String sql = "UPDATE CHIMAC SET CMBALANCE = CMBALANCE + ? WHERE CMID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, chimac.getCmBalance());
			pstmt.setString(2, chimac.getCmId());
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("처리 완료.");
			} else {
				System.out.println("처리 실패.");
			}
			
			
		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	public void withdraw(CMDTO chimac) { // 출금 메소드
		String sql = "UPDATE CHIMAC SET CMBALANCE = CMBALANCE - ? WHERE CMID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, chimac.getCmBalance());
			pstmt.setString(2, chimac.getCmId());
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("처리 완료.");
			} else {
				System.out.println("처리 실패.");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public int checkBalance(String cId) { // 계좌 체크 메소드
		String sql = "SELECT CMBALANCE FROM CHIMAC WHERE CMID = ?";
		int cAccount = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cAccount = rs.getInt(1);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return cAccount;
	}
	//리뷰입력 
	public void review(CMDTO chimac) {
		String sql = "INSERT INTO REVIEW VALUES(?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, chimac.getCmId());
			pstmt.setString(2, chimac.getCmMenu());
			pstmt.setInt(3, chimac.getCmReviewNo());
			pstmt.setString(4, chimac.getCmReview());
			

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("리뷰 등록 성공!");
			} else {
				System.out.println("리뷰 등록 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // end 리뷰입력
	
	
	//리뷰 조회
	public void reviewList() {
		String sql = "SELECT * FROM REVIEW";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int i = 1;
			while (rs.next()) {
				System.out.println(i + "번째 리뷰 ");
				System.out.println("닉네임 : " + rs.getString(1));
				System.out.println("메뉴  : " + rs.getString(2));
				System.out.println("리뷰  : " + rs.getString(4));
				System.out.println();
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // end 리뷰 조회 
	
	
	//리뷰 수정
	public void reviewModify(CMDTO chimac) {
		String sql = "UPDATE REVIEW SET CMID=?, MENUNAME=?, REVIEW=? WHERE REVIEWNO=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, chimac.getCmId());
			pstmt.setString(2, chimac.getCmMenu());
			pstmt.setString(3, chimac.getCmReview());
			pstmt.setInt(4, chimac.getCmReviewNo());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("리뷰 수정 성공");
			} else {
				System.out.println("리뷰 수정 실패....");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // end 리뷰 수정
	
	
	//리뷰수정체크
	public boolean reviewCheck(int reviewNo, String cmId1) {
		String sql = "SELECT CMID FROM REVIEW WHERE CMID=? AND REVIEWNO=?";
		boolean checkResult = false;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, cmId1);
			pstmt.setInt(2, reviewNo);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				checkResult = true;
			} else {
				checkResult = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkResult;
	} // end 리뷰수정 체크
	
	
	//리뷰삭제
	public void reviewDelete(int reviewNo) {
		String sql = "DELETE REVIEW WHERE REVIEWNO=?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, reviewNo);

			int result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("리뷰 삭제 성공");
			} else {
				System.out.println("리뷰 삭제 실패.....");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // end 리뷰삭제
	
	
	//장바구니 비우기
	public void basketdelete() {
		String sql = "DELETE BASKET";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.executeUpdate();
			System.out.println("장바구니가 비워졌습니다 .");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // end 장바구니 비우기
	
	
	//장바구니 조회 1
	public void basketList() {
		String sql = "SELECT * FROM BASKET";

		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				System.out.println("메뉴 : " + rs.getString(1));
				System.out.println("가격 : " + rs.getInt(2));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // end 장바구니 조회1
	
	
	//장바구니 조회 2 (가격의합)
	public void basketList2() {
		String sql1 = "SELECT SUM(PRICE) FROM BASKET";
		try {
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				System.out.println("결제금액 : " + rs.getString(1));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // end 장바구니 조회2

	
	//=================================
	
	
	// 치킨 선택해서 장바구니 넣기
	public void menuchoice(String chicken, int price) {
		String sql = "INSERT INTO BASKET VALUES(?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1 ,chicken);
			pstmt.setInt(2 ,price);
			
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("장바구니 담기 성공!");
			} else {
				System.out.println("장바구니 담기 실패!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
		
	}

	// 맥주 선택해서 장바구니 넣기
	public void beerchoice(String beer, int price) {
		String sql = "INSERT INTO BASKET VALUES(?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1 ,beer);
			pstmt.setInt(2 ,price);
			
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("장바구니 담기 성공!");
			} else {
				System.out.println("장바구니 담기 실패!");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		
	}
}
