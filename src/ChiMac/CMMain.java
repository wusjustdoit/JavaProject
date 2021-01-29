package ChiMac;

import java.util.Scanner;

public class CMMain {

	public static void main(String[] args) {
		CMDAO server = new CMDAO();
		CMDTO chimac = new CMDTO();
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;    //메인 페이지
		boolean run1 = true;   //로그인하면 들어가는 페이지
		boolean run1_1 = true; //검색
		boolean run1_2 = true; //장바구니
		boolean run1_3 = true; //입금
		boolean run1_4 = true; //리뷰
		boolean run2 = true;   //치킨브랜드 선택
		boolean run2_1 = true; //BBQ선택
		boolean run2_2 = true; //교촌선택
		boolean run2_3 = true; //굽네선택
		boolean run2_4 = true; //BHC선택
		boolean run2_5 = true; //호식이선택
		boolean run2_6 = true; //멕시카나선택
		boolean run2_7 = true; //페리카나선택
		boolean run2_8 = true; //처갓집선택
		boolean run2_9 = true; //콜라선택
		boolean run3 = true;   //맥주선택
		boolean run3_1 = true; //맥주4개구매
		
		int menu = 0;
		
		server.connect();
		
		
		while(run) {
			System.out.println();
			System.out.println("🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗");
			System.out.println("🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺");
			System.out.println();
			System.out.println("           오늘 치맥 어때? ");
			System.out.println();
			System.out.println("오늘은 치맥DAY~ 방문해 주신 여러분 환영합니다.");
			System.out.println("원하시는 메뉴를 선택해주세요!! o(^-^)o ");
			System.out.println();
			System.out.println("🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺*🍺");
			System.out.println("🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗*🍗");
			System.out.println();
			System.out.println("=========메인 페이지=========");
			System.out.println("1.로그인 | 2.회원가입 | 3.종료");
			System.out.println("=========================");
			System.out.print("메뉴 선택 >> ");
			menu = sc.nextInt();
			
			
			switch(menu) {
			
			case 1 : //로그인
				
				System.out.print("아이디 입력 >> ");
				String cId = sc.next();
				
				System.out.print("비밀번호 입력 >> ");
				String cPw = sc.next();
				
				boolean check = server.idCheck(cId,cPw);
				
				if(check) {
					System.out.println("로그인 성공!");
					run1 = true;
					
				while(run1) {
					System.out.println();
		               System.out.println("=======================================");
		               System.out.println("1.검색      | 2.장바구니 확인 및 결제  | 3.계좌확인 ");
		               System.out.println("4.게시판   | 5.회원정보 수정             | 6.회원정보 확인");
		               System.out.println("7.회원탈퇴| 8.로그아웃 ");
		               System.out.println("=======================================");
		               System.out.print("메뉴 선택 >> ");
		               menu = sc.nextInt();
					
					switch(menu) {
					
					case 1 : //검색
						
						run1_1 = true;
						while(run1_1) {
							System.out.println();
							System.out.println("========================================");
							System.out.println("1. 치킨🍗 선택하기 | 2.맥주🍺 선택하기 | 3.뒤로가기");
							System.out.println("========================================");
							System.out.print("메뉴 선택 >> ");
							menu = sc.nextInt();
							
							switch(menu) {
							
							case 1 : //치킨선택
								
								run2 = true;
								while(run2) {
									System.out.println();
									System.out.println("===================== 치킨 선택 =====================");
									System.out.println("1.BBQ	| 2.교촌		| 3.굽네		| 4.BHC");
									System.out.println("5.호식이	| 6.멕시카나	| 7.페리카나	| 8.처갓집");
									System.out.println("9.콜라추가	| 10.뒤로가기");
									System.out.println("=================================================");
									System.out.print("메뉴 선택 >> ");
									menu = sc.nextInt();
									
									int price =0;
									String chicken = "없음";
									
									switch(menu) {
									
									case 1 : //BBQ
										
										run2_1 = true;
										while(run2_1) {
											System.out.println();
											System.out.println("================================BBQ================================");
											System.out.println("1.(BBQ)황금올리브치킨    | 2.(BBQ)핫 황금올리브 크리스피 | 3.(BBQ)핫 황금올리브 블랙페퍼");
											System.out.println("4.(BBQ)오리지널 양념치킨| 5.(BBQ)황금올리브 반반           | 6.뒤로가기 ");
											System.out.println("===================================================================");
											System.out.print("메뉴 선택 >> ");
											menu = sc.nextInt();
											
											switch(menu) {
											
											case 1 :
												chicken = "황금올리브치킨";
												price = 18000;
												break;
											case 2 :
												chicken = "핫 황금올리브 크리스피";
												price = 19000;
												break;
											case 3 :
												chicken = "핫 황금올리브 블랙페퍼";
												price = 19000;
												break;
											case 4 :
												chicken = "오리지널 양념치킨";
												price = 19500;
												break;
											case 5 :
												chicken = "황금올리브 반반";
												price = 19000;
												break;
											case 6 : //뒤로가기
												run2_1 = false;
												break;
											default :
												System.out.println("해당 메뉴는 존재하지 않습니다.");
												break;
											
											} // end BBQ 2_1 switch
											
											if(menu < 6) {
												System.out.println();
												System.out.println("주문하신 메뉴는 " + chicken);
												System.out.println("가격은 " + price + "원 입니다!");
												System.out.println();
												System.out.println("장바구니에 담으시려면 1을, 다른 메뉴를 선택하시려면 2를 눌러주세요!");
												System.out.print("숫자 입력 >> ");
												int choice = sc.nextInt();
											
												if(choice == 1 ) {
													server.menuchoice(chicken,price);
													run2_1 = false;
												
												} else if(choice == 2) {
													run2_1 = false;
												} else {
													System.out.println("다시 선택해주세요!");
													run2_1 = false;
												}
											} // end if 
											
											
										} // end BBQ 2_1 while
										
										break;
										
									case 2 : //교촌
										
										run2_2 = true;
										while(run2_2) {
											System.out.println();
											System.out.println("==================교촌==================");
											System.out.println("1.교촌 콤보       | 2.교촌 레드 콤보 | 3.교촌 허니 콤보");
											System.out.println("4.교촌 반반 콤보| 5.교촌 레드 윙    | 6.뒤로가기 ");
											System.out.println("=======================================");
											System.out.print("메뉴 선택 >> ");
											menu = sc.nextInt();
											
											switch(menu) {
											
											case 1 :
												chicken = "교촌 콤보";
												price = 17000;
												break;
											case 2 :
												chicken = "교촌 레드 콤보";
												price = 18000;
												break;
											case 3 :
												chicken = "교촌 허니 콤보";
												price = 18000;
												break;
											case 4 :
												chicken = "교촌 반반 콤보";
												price = 18000;
												break;
											case 5 :
												chicken = "교촌 레드 윙";
												price = 18000;
												break;
											case 6 : //뒤로가기
												run2_2 = false;
												break;
											default :
												System.out.println("해당 메뉴는 존재하지 않습니다.");
												break;
											
											} // end 교촌 2_2 switch
											
											if(menu < 6) {
												System.out.println();
												System.out.println("주문하신 메뉴는 " + chicken);
												System.out.println("가격은 " + price + "원 입니다!");
												System.out.println();
												System.out.println("장바구니에 담으시려면 1을, 다른 메뉴를 선택하시려면 2를 눌러주세요!");
												System.out.print("숫자 입력 >> ");
												int choice = sc.nextInt();
											
												if(choice == 1 ) {
													server.menuchoice(chicken,price);
													run2_2 = false;
												
												} else if(choice == 2) {
													run2_2 = false;
												} else {
													System.out.println("다시 선택해주세요!");
													run2_2 = false;
												}
											} // end if 
											
										} // end 교촌 2_2 while
										
										break;
										
									case 3 : //굽네
										
										run2_3 = true;
										while(run2_3) {
											System.out.println();
											System.out.println("======================굽네======================");
											System.out.println("1.굽네 오리지널        | 2.굽네 고추 바사삭 | 3.굽네 고추 바사삭 순살");
											System.out.println("4.굽네 고추 바사삭 윙| 5.굽네 갈비천왕     | 6.뒤로가기 ");
											System.out.println("===============================================");
											System.out.print("메뉴 선택 >> ");
											menu = sc.nextInt();
											
											switch(menu) {
											
											case 1 :
												chicken = "굽네 오리지널";
												price = 15000;
												break;
											case 2 :
												chicken = "굽네 고추 바사삭";
												price = 16000;
												break;
											case 3 :
												chicken = "굽네 고추 바사삭 순살";
												price = 19000;
												break;
											case 4 :
												chicken = "굽네 고추 바사삭 윙";
												price = 18000;
												break;
											case 5 :
												chicken = "굽네 갈비천왕";
												price = 17000;
												break;
											case 6 : //뒤로가기
												run2_3 = false;
												break;
											default :
												System.out.println("해당 메뉴는 존재하지 않습니다.");
												break;
											
											} // end 굽네 2_3 switch
											
											if(menu < 6) {
												System.out.println();
												System.out.println("주문하신 메뉴는 " + chicken);
												System.out.println("가격은 " + price + "원 입니다!");
												System.out.println();
												System.out.println("장바구니에 담으시려면 1을, 다른 메뉴를 선택하시려면 2를 눌러주세요!");
												System.out.print("숫자 입력 >> ");
												int choice = sc.nextInt();
											
												if(choice == 1 ) {
													server.menuchoice(chicken,price);
													run2_3 = false;
												
												} else if(choice == 2) {
													run2_3 = false;
												} else {
													System.out.println("다시 선택해주세요!");
													run2_3 = false;
												}
											} // end if 
											
										} // end 굽네 2_3 while
										
										break;
										
									case 4 : //BHC 
										
										run2_4 = true;
										while(run2_4) {
											System.out.println();
											System.out.println("=======================BHC=======================");
											System.out.println("1.(BHC)뿌링클   | 2.(BHC)뿌링클 순살             | 3.(BHC)맛초킹");
											System.out.println("4.(BHC)골드킹   | 5.(BHC)후라이드 반+양념반  | 6.뒤로가기 ");
											System.out.println("=================================================");
											System.out.print("메뉴 선택 >> ");
											menu = sc.nextInt();
											
											switch(menu) {
											
											case 1 :
												chicken = "뿌링클";
												price = 17000;
												break;
											case 2 :
												chicken = "뿌링클 순살";
												price = 19000;
												break;
											case 3 :
												chicken = "맛초킹";
												price = 17000;
												break;
											case 4 :
												chicken = "골드킹";
												price = 16000;
												break;
											case 5 :
												chicken = "후라이드 반+양념반";
												price = 16000;
												break;
											case 6 : //뒤로가기
												run2_4 = false;
												break;
											default :
												System.out.println("해당 메뉴는 존재하지 않습니다.");
												break;
											
											} // end BHC 2_4 switch
											
											if(menu < 6) {
												System.out.println();
												System.out.println("주문하신 메뉴는 " + chicken);
												System.out.println("가격은 " + price + "원 입니다!");
												System.out.println();
												System.out.println("장바구니에 담으시려면 1을, 다른 메뉴를 선택하시려면 2를 눌러주세요!");
												System.out.print("숫자 입력 >> ");
												int choice = sc.nextInt();
											
												if(choice == 1 ) {
													server.menuchoice(chicken,price);
													run2_4 = false;
												
												} else if(choice == 2) {
													run2_4 = false;
												} else {
													System.out.println("다시 선택해주세요!");
													run2_4 = false;
												}
											} // end if 
											
										} // end BHC 2_4 while
										
										break;
										
									case 5 : //호식이
										
										run2_5 = true;
										while(run2_5) {
											System.out.println();
											System.out.println("================================호식이================================");
											System.out.println("1.(호식이)한마리+한마리+콜라1 | 2.(호식이)순살+순살+콜라1	| 3.(호식이)한마리+콜라1");
											System.out.println("4.(호식이)플라윙 세트+콜라1   | 5.(호식이)뿌라이드 한마리+콜라1	| 6.뒤로가기 ");
											System.out.println("====================================================================");
											System.out.print("메뉴 선택 >> ");
											menu = sc.nextInt();
											
											switch(menu) {
											
											case 1 :
												chicken = "한마리+한마리+콜라1";
												price = 21000;
												break;
											case 2 :
												chicken = "순살+순살+콜라1";
												price = 21000;
												break;
											case 3 :
												chicken = "한마리+콜라1";
												price = 14000;
												break;
											case 4 :
												chicken = "플라윙 세트+콜라1";
												price = 20000;
												break;
											case 5 :
												chicken = "뿌라이드 한마리+콜라1";
												price = 16000;
												break;
											case 6 : //뒤로가기
												run2_5 = false;
												break;
											default :
												System.out.println("해당 메뉴는 존재하지 않습니다.");
												break;
											
											} // end 호식이 2_5 switch
											
											if(menu < 6) {
												System.out.println();
												System.out.println("주문하신 메뉴는 " + chicken);
												System.out.println("가격은 " + price + "원 입니다!");
												System.out.println();
												System.out.println("장바구니에 담으시려면 1을, 다른 메뉴를 선택하시려면 2를 눌러주세요!");
												System.out.print("숫자 입력 >> ");
												int choice = sc.nextInt();
											
												if(choice == 1 ) {
													server.menuchoice(chicken,price);
													run2_5 = false;
												
												} else if(choice == 2) {
													run2_5 = false;
												} else {
													System.out.println("다시 선택해주세요!");
													run2_5 = false;
												}
											} // end if 
											
										} // end 호식이 2_5 while
										
										break;
										
									case 6 : //멕시카나
										
										run2_6 = true;
										while(run2_6) {
											System.out.println();
											System.out.println("============================멕시카나===========================");
											System.out.println("1.(멕시카나)후라이드             | 2.(멕시카나)양념치킨           | 3.(멕시카나)반반치킨 ");
											System.out.println("4.(멕시카나)뿌리고-오리지날  | 5.(멕시카나)모두의마요치킨  | 6.뒤로가기 ");
											System.out.println("============================================================");
											System.out.print("메뉴 선택 >> ");
											menu = sc.nextInt();
											
											switch(menu) {
											
											case 1 :
												chicken = "후라이드";
												price = 16000;
												break;
											case 2 :
												chicken = "양념치킨";
												price = 17000;
												break;
											case 3 :
												chicken = "반반치킨";
												price = 16000;
												break;
											case 4 :
												chicken = "뿌리고(오리지날)";
												price = 19000;
												break;
											case 5 :
												chicken = "모두의마요치킨";
												price = 18000;
												break;
											case 6 : //뒤로가기
												run2_6 = false;
												break;
											default :
												System.out.println("해당 메뉴는 존재하지 않습니다.");
												break;
											
											} // end 멕시카나 2_6 switch
											
											if(menu < 6) {
												System.out.println();
												System.out.println("주문하신 메뉴는 " + chicken);
												System.out.println("가격은 " + price + "원 입니다!");
												System.out.println();
												System.out.println("장바구니에 담으시려면 1을, 다른 메뉴를 선택하시려면 2를 눌러주세요!");
												System.out.print("숫자 입력 >> ");
												int choice = sc.nextInt();
											
												if(choice == 1 ) {
													server.menuchoice(chicken,price);
													run2_6 = false;
												
												} else if(choice == 2) {
													run2_6 = false;
												} else {
													System.out.println("다시 선택해주세요!");
													run2_6 = false;
												}
											} // end if 
											
										} // end 멕시카나 2_6 while
										
										break;
										
									case 7 : //페리카나
										
										run2_7 = true;
										while(run2_7) {
											System.out.println();
											System.out.println("=============================페리카나==============================");
											System.out.println("1.(페리카나)후라이드               | 2.(페리카나)양념치킨                 | 3.(페리카나)간장치킨  ");
											System.out.println("4.(페리카나)후라이드반+양념반 | 5.(페리카나)다리만 후라이드치킨 | 6.뒤로가기 ");
											System.out.println("================================================================");
											System.out.print("메뉴 선택 >> ");
											menu = sc.nextInt();
											
											switch(menu) {
											
											case 1 :
												chicken = "후라이드";
												price = 16000;
												break;
											case 2 :
												chicken = "양념치킨";
												price = 17000;
												break;
											case 3 :
												chicken = "간장치킨";
												price = 17000;
												break;
											case 4 :
												chicken = "후라이드반+양념반";
												price = 17000;
												break;
											case 5 :
												chicken = "다리만 후라이드치킨";
												price = 18000;
												break;
											case 6 : //뒤로가기
												run2_7 = false;
												break;
											default :
												System.out.println("해당 메뉴는 존재하지 않습니다.");
												break;
											
											} // end 페리카나 2_7 switch
											
											if(menu < 6) {
												System.out.println();
												System.out.println("주문하신 메뉴는 " + chicken);
												System.out.println("가격은 " + price + "원 입니다!");
												System.out.println();
												System.out.println("장바구니에 담으시려면 1을, 다른 메뉴를 선택하시려면 2를 눌러주세요!");
												System.out.print("숫자 입력 >> ");
												int choice = sc.nextInt();
											
												if(choice == 1 ) {
													server.menuchoice(chicken,price);
													run2_7 = false;
												
												} else if(choice == 2) {
													run2_7 = false;
												} else {
													System.out.println("다시 선택해주세요!");
													run2_7 = false;
												}
											} // end if 
											
										} // end 페리카나 2_7 while
										
										break;
										
									case 8 : //처갓집
										
										run2_8 = true;
										while(run2_8) {
											System.out.println();
											System.out.println("=============================처갓집============================");
											System.out.println("1.(처갓집)슈프림양념치킨               | 2.(처갓집)후라이드              | 3.(처갓집)닭강정");
											System.out.println("4.(처갓집)후라이드반+슈프림양념반 | 5.(처갓집)와락(간장)치킨    | 6.뒤로가기 ");
											System.out.println("=============================================================");
											System.out.print("메뉴 선택 >> ");
											menu = sc.nextInt();
											
											switch(menu) {
											
											case 1 :
												chicken = "슈프림양념치킨";
												price = 18000;
												break;
											case 2 :
												chicken = "후라이드";
												price = 16000;
												break;
											case 3 :
												chicken = "닭강정";
												price = 18000;
												break;
											case 4 :
												chicken = "후라이드반+슈프림양념반";
												price = 18000;
												break;
											case 5 :
												chicken = "와락(간장)치킨";
												price = 18000;
												break;
											case 6 : //뒤로가기
												run2_8 = false;
												break;
											default :
												System.out.println("해당 메뉴는 존재하지 않습니다.");
												break;
											
											} // end 처갓집 2_8 switch
											
											if(menu < 6) {
												System.out.println();
												System.out.println("주문하신 메뉴는 " + chicken);
												System.out.println("가격은 " + price + "원 입니다!");
												System.out.println();
												System.out.println("장바구니에 담으시려면 1을, 다른 메뉴를 선택하시려면 2를 눌러주세요!");
												System.out.print("숫자 입력 >> ");
												int choice = sc.nextInt();
											
												if(choice == 1 ) {
													server.menuchoice(chicken,price);
													run2_8 = false;
												
												} else if(choice == 2) {
													run2_8 = false;
												} else {
													System.out.println("다시 선택해주세요!");
													run2_8 = false;
												}
											} // end if 
											
										} // end 처갓집 2_8 while
										
										break;
										
									case 9 : //콜라추가
										
										run2_9 = true;
										while(run2_9) {
											System.out.println();
											System.out.println("========콜라 추가========");
											System.out.println("1.콜라(1.25L)| 2.뒤로가기");
											System.out.println("======================");
											System.out.print("메뉴 선택 >> ");
											menu = sc.nextInt();
											
											switch(menu) {
											
											case 1 :
												chicken = "콜라";
												price = 2000;
												break;
												
											case 2 : //뒤로가기
												run2_9 = false;
												break;
											
											default :
												System.out.println("해당 메뉴는 존재하지 않습니다.");
												break;
											
											} // end 콜라추가 2_9 switch
											
											if(menu < 2) {
												System.out.println();
												System.out.println("주문하신 메뉴는 " + chicken);
												System.out.println("가격은 " + price + "원 입니다!");
												System.out.println();
												System.out.println("장바구니에 담으시려면 1을, 다른 메뉴를 선택하시려면 2를 눌러주세요!");
												System.out.print("숫자 입력 >> ");
												int choice = sc.nextInt();
											
												if(choice == 1 ) {
													server.menuchoice(chicken,price);
													run2_9 = false;
												
												} else if(choice == 2) {
													run2_9 = false;
												} else {
													System.out.println("다시 선택해주세요!");
													run2_9 = false;
												}
											} // end if 
											
										} // end 콜라추가 2_9 while
										
										break;
										
									case 10 : //뒤로가기
										run2 = false;
										break;
										
									default :
										System.out.println("다시 입력해주세요!");
										break;
										
									} // end 치킨선택 2 switch
									
								} // end 치킨선택 2 while
								
								break;
								
							case 2 : //맥주선택
								
								run3 = true;
								while(run3) {
									System.out.println();
									System.out.println("================ 맥주 선택 ==================");
									System.out.println("1.테라       | 2.카스            | 3.버드와이저   | 4.칭따오");
									System.out.println("5.하이네켄 | 6.블랑            | 7.기네스         | 8.호가든");
									System.out.println("9.스텔라    | 10. 4개 구매 | 11.뒤로가기");
									System.out.println("=========================================");
									System.out.print("메뉴 선택 >> ");
									menu = sc.nextInt();
									
									int price =0;
									String beer = "없음";
									
									switch(menu) {
									
									case 1 :
										beer = "테라";
										price = 2700;
										break;
									case 2 :
										beer = "카스";
										price = 2700;
										break;
									case 3 :
										beer = "버드와이저";
										price = 2900;
										break;
									case 4 :
										beer = "칭따오";
										price = 3000;
										break;
									case 5 :
										beer = "하이네켄";
										price = 3000;
										break;
									case 6 :
										beer = "블랑";
										price = 3000;
										break;
									case 7 :
										beer = "기네스";
										price = 3000;
										break;
									case 8 :
										beer = "호가든";
										price = 3000;
										break;
									case 9 :
										beer = "스텔라";
										price = 3000;
										break;
										
									case 10 : //4개 선택 만원
										
										String one = "선택안함";
										String two = "선택안함";
										String three = "선택안함";
										String four = "선택안함";
										int fourbeerprice = 10000;
										
										run3_1 = true;
										while(run3_1) {
											System.out.println();
											System.out.println("===============4개 선택 만원==================");
											System.out.println("1.테라       | 2.카스            | 3.버드와이저   | 4.칭따오");
											System.out.println("5.하이네켄 | 6.블랑            | 7.기네스         | 8.호가든");
											System.out.println("9.스텔라");
											System.out.println("=========================================");
											System.out.print("1번 맥주 선택 >> ");
											int onebeer = sc.nextInt();
											
											
											switch(onebeer) {
											
											case 1 :
												one = "테라";
												break;
											case 2 :
												one = "카스";
												break;
											case 3 :
												one = "버드와이저";
												break;
											case 4 :
												one = "칭따오";
												break;
											case 5 :
												one = "하이네켄";
												break;
											case 6 :
												one = "블랑";
												break;
											case 7 :
												one = "기네스";
												break;
											case 8 :
												one = "호가든";
												break;
											case 9 :
												one = "스텔라";
												break;
											
											} // end 1번 맥주선택 switch
											
											
											System.out.print("2번 맥주 선택 >> ");
											int twobeer = sc.nextInt();
											
											switch(twobeer) {
											
											case 1 :
												two = "테라";
												break;
											case 2 :
												two = "카스";
												break;
											case 3 :
												two = "버드와이저";
												break;
											case 4 :
												two = "칭따오";
												break;
											case 5 :
												two = "하이네켄";
												break;
											case 6 :
												two = "블랑";
												break;
											case 7 :
												two = "기네스";
												break;
											case 8 :
												two = "호가든";
												break;
											case 9 :
												two = "스텔라";
												break;
											
											} // end 2번 맥주선택 switch
											
											
											System.out.print("3번 맥주 선택 >> ");
											int threebeer = sc.nextInt();
											
											switch(threebeer) {
											
											case 1 :
												three = "테라";
												break;
											case 2 :
												three = "카스";
												break;
											case 3 :
												three = "버드와이저";
												break;
											case 4 :
												three = "칭따오";
												break;
											case 5 :
												three = "하이네켄";
												break;
											case 6 :
												three = "블랑";
												break;
											case 7 :
												three = "기네스";
												break;
											case 8 :
												three = "호가든";
												break;
											case 9 :
												three = "스텔라";
												break;
											
											} // end 3번 맥주선택 switch
											
											
											System.out.print("4번 맥주 선택 >> ");
											int fourbeer = sc.nextInt();
											
											switch(fourbeer) {
											
											case 1 :
												four = "테라";
												break;
											case 2 :
												four = "카스";
												break;
											case 3 :
												four = "버드와이저";
												break;
											case 4 :
												four = "칭따오";
												break;
											case 5 :
												four = "하이네켄";
												break;
											case 6 :
												four = "블랑";
												break;
											case 7 :
												four = "기네스";
												break;
											case 8 :
												four = "호가든";
												break;
											case 9 :
												four = "스텔라";
												break;
											
											} // end 4번 맥주선택 switch
											
											
											System.out.println();
											System.out.println("주문하신 맥주는 " + one + ", "+ two + ", " + three + ", " + four + "입니다.");
											
											System.out.println();
											System.out.println("가격은 " + fourbeerprice + "원 입니다!");
											System.out.println();
											System.out.println("장바구니에 담으시려면 1을, 다른 메뉴를 선택하시려면 2를 눌러주세요!");
											System.out.print("숫자 입력 >> ");
											int choice = sc.nextInt();
										
											if(choice == 1 ) {
												server.fourbeerchoice(one, two, three, four);
												run2_9 = false;
											
											} else if(choice == 2 ){
												run2_9 = false;
											} else {
												System.out.println("다시 선택해주세요!");
												run2_9 = false;
											}
											
											run3_1 = false;
										} // end 4개맥주구매 3_1 while     
											
										
										break;
										
									case 11 :
										run3 = false;
										break;
										
									default :
										System.out.println("해당 메뉴는 존재하지 않습니다.");
										break;
					
									} // end 맥주선택 3 switch
									
									if( menu < 10) {
										System.out.println();
										System.out.println("주문하신 맥주는 " + beer);
										System.out.println("가격은 " + price + "원 입니다!");
										System.out.println();
										System.out.println("장바구니에 담으시려면 1을, 다른 메뉴를 선택하시려면 2를 눌러주세요!");
										System.out.print("숫자 입력 >> ");
										int choice = sc.nextInt();
									
										if(choice == 1 ) {
											server.beerchoice(beer,price);
											run2_9 = false;
										
										} else if(choice == 2 ){
											run2_9 = false;
										} else {
											System.out.println("다시 선택해주세요!");
											run2_9 = false;
										}
									} // end if
									
								} // end 맥주선택 3 while
								break;
								
							case 3 : //뒤로가기
								run1_1 = false;
								break;
								
							default :
								System.out.println("다시 입력해주세요!");
								break;
							
							
							} //end 검색 1_1 switch
						} //end 검색 1_1 while
						
						break;
						
						
					case 2 : //장바구니 확인 및 결제
						
						run1_2 = true;
						while(run1_2) {
							System.out.println();
							System.out.println("===========================================");
							System.out.println("1.장바구니 확인 | 2.결제 | 3.장바구니 비우기 | 4.뒤로가기");
							System.out.println("===========================================");
							System.out.print("메뉴 선택 >> ");
							menu = sc.nextInt();
							
							switch(menu) {
							
							case 1 : //장바구니 확인
								server.basketList();
								server.basketList2();
								
								
								
								break;
								
							case 2 : //결제
								System.out.print("아이디 >> ");
								cId = sc.next();
								
								System.out.print("비밀번호 >> ");
								cPw = sc.next();
								boolean recheck = server.idCheck(cId, cPw);
								if (recheck) {
									System.out.println("주소를 확인해 주십시오.");
									System.out.println("기존 주소는 아래와 같습니다.");
									server.oldAdd(cId);
									System.out.println("1. 기존 주소 사용 | 2. 새 주소 입력");
									int Add = sc.nextInt();
									switch (Add) {
									case 1:
										
										int cBalance = server.checkBalance(cId);
										server.basketList4();
										int pay = server.basketList3();
										
										System.out.println("1. 결제 | 2. 뒤로 가기");
										int cpay = sc.nextInt();
										switch (cpay) {
										case 1:
											if (cBalance >= pay) {
												
												chimac.setCmId(cId);
												chimac.setCmBalance(cBalance);
												
												server.withdraw1(cId,pay);
												server.basketdelete();
											} else {
												System.out.println("잔액이 " + (pay - cBalance) + "원 부족합니다!");
												System.out.println(
														"현재 잔액은 " + cBalance + "원, 결제 요청금액은 " + pay + "원 입니다.");
												break;
											}
											break;
										case 2:
											break;
										default : 
											System.out.println("잘못 입력하셨습니다 다시 입력해 주세요 .");
											break;
										}
										break;
									case 2:
										// 새 주소 입력
										System.out.print("새 주소를 입력해주세요 >>");
										sc.nextLine();
										String newAddr = sc.nextLine();
										System.out.println("새 주소는 : " + newAddr + " 입니다.");
										cBalance = server.checkBalance(cId);
										server.basketList4();
										pay = server.basketList3();
										
										System.out.println("1. 결제 | 2. 뒤로 가기");
										cpay = sc.nextInt();
										switch (cpay) {
										case 1:
											if (cBalance >= pay) {
												
												chimac.setCmId(cId);
												chimac.setCmBalance(cBalance);
												
												server.withdraw1(cId,pay);
												server.basketdelete();
											} else {
												System.out.println("잔액이 " + (pay - cBalance) + "원 부족합니다!");
												System.out.println(
														"현재 잔액은 " + cBalance + "원, 결제 요청금액은 " + pay + "원 입니다.");
												break;
											}
											break;
										case 2:
											break;
											default : 
												System.out.println("잘못 입력하셨습니다 다시 입력해 주세요 .");
												break;
										}
										break;
									default:
										System.out.println("잘못 입력하셨습니다 다시 입력해 주세요 .");
										break;
									}
								}
								break;
								
							case 3 : //장바구니 비우기
								server.basketdelete();
								break;
								
							case 4 : //뒤로가기
								run1_2 = false;
								break;
								
							default :
								System.out.println("다시 입력해주세요!");
								break;
							
							
							} //end 장바구니 확인 및 결제 1_2 switch
						} //end 장바구니 확인 및 결제 1_2 while
						
						break;
						
					case 3 : //계좌 확인
						run1_3 = true;
						while(run1_3) {
							System.out.println();
							System.out.println("==========================================");
							System.out.println("1.입금 | 2.출금 | 3.잔액조회  | 4.뒤로가기");
							System.out.println("==========================================");
							System.out.print("메뉴 선택 >> ");
							menu = sc.nextInt();
							
							switch(menu) {
							
							case 1 : //입금

								System.out.print("입금액 >> ");
								int plusBalance = sc.nextInt();
								
								chimac.setCmId(cId);
								chimac.setCmPw(cPw);
								chimac.setCmBalance(plusBalance);
								server.deposit(chimac);
								break;

							case 2 : //출금
								System.out.print("아이디 >> ");
								cId = sc.next();
								System.out.print("비밀번호 >> ");
								cPw = sc.next();
								boolean recheck = server.idCheck(cId,cPw);
								
								if(recheck) {
									int cBalance = server.checkBalance(cId);
									System.out.print("출금액 >> ");
									int minusBalance = sc.nextInt();
									
									if(cBalance >= minusBalance) {
										chimac.setCmId(cId);
										chimac.setCmPw(cPw);
										chimac.setCmBalance(minusBalance);
										server.withdraw(chimac);
									} else {
										System.out.println("출금액이 " + (minusBalance - cBalance) + "원 부족합니다!");
										System.out.println("현재 잔액은 " + cBalance + "원, 출금 요청금액은 " + minusBalance + "원 입니다.");
										break;
									}	    
									
									break;
								} else {
									System.out.println("아이디와 비밀번호를 다시 확인해주세요.");
								}
								
								break;
							case 3 : //잔액조회
									int cBalance = server.checkBalance(cId);
									System.out.println("잔액조회 : " + cBalance);

								break;
								
							case 4 : //뒤로가기
								run1_3 = false;
								break;
		
							default :
								System.out.println("다시 입력해주세요!");
								break;
							
							
							} //end case 1_3 switch
						} //end case 1_3 while
						
						break;
						
					case 4 : //게시판
						
						run1_4 = true;
						while(run1_4) {
							System.out.println();
							System.out.println("==============================");
							System.out.println("1.리뷰조회   | 2.리뷰작성   | 3.리뷰수정");
							System.out.println("4.리뷰삭제   | 5.뒤로가기 ");
							System.out.println("==============================");
							System.out.print("메뉴 선택 >> ");
							menu = sc.nextInt();
							
							switch(menu) {
							
							case 1 : //리뷰조회
								server.reviewList();
								break;
								
							case 2 : //리뷰작성
								System.out.println("리뷰 작성 화면입니다");
								
								System.out.print("닉네임 입력 >> ");
								String cmId1 = sc.next();
								chimac.setCmId(cmId1);

								System.out.print("주문 메뉴이름 입력 >> ");
								sc.nextLine().trim();
								String cmMenu = sc.nextLine();
								chimac.setCmMenu(cmMenu);
								
								

								System.out.print("리뷰 번호를정해주세요.(4자리까지 입력가능, 리뷰 수정시 필요,변경불가능 ) >> ");
							
								int ReviewNo = sc.nextInt();
				
								if(ReviewNo > 9999) {
							
									System.out.println("리뷰번호는 최대 4자리수입니다.");
									break;
								} else {
									chimac.setCmReviewNo(ReviewNo);
									}

								System.out.println("리뷰를 작성해 주세요.");
								System.out.println("리뷰는 100글자까지만 입력 가능합니다.");
								System.out.println("리뷰 내용 >> ");
								sc.nextLine().trim();
								String cmReview = sc.nextLine();
								chimac.setCmReview(cmReview);

								server.review(chimac);
								
								break;
								
							case 3 : //리뷰수정
								System.out.print("수정할 리뷰의 리뷰번호 >> ");
								ReviewNo = sc.nextInt();
								chimac.setCmReviewNo(ReviewNo);

								System.out.print("회원 닉네임 >> ");
								cmId1 = sc.next();
								chimac.setCmId(cmId1);

								System.out.print("주문 메뉴이름 >> ");
								sc.nextLine().trim();
								cmMenu = sc.nextLine();
								chimac.setCmMenu(cmMenu);

								System.out.println("리뷰는 100글자까지만 입력 가능합니다.");
								System.out.println("리뷰내용  >> ");
								cmReview = sc.nextLine();
								chimac.setCmReview(cmReview);
								
								
								server.reviewModify(chimac);
								
								break;
								
							case 4 : //리뷰삭제
								System.out.print("삭제할 리뷰번호 >> ");
								ReviewNo = sc.nextInt();
								System.out.print("삭제할 리뷰 작성자 닉네임 >> ");
								cmId1 = sc.next();

								boolean reviewCheck = server.reviewCheck(ReviewNo, cmId1);

								if (reviewCheck) {
									server.reviewDelete(ReviewNo);
								} else {

									System.out.println("닉네임과 리뷰번호가 일치하지 않습니다");
								}
								
								break;
								
							case 5 : //뒤로가기
								run1_4 = false;
								break;
		
							default :
								System.out.println("다시 입력해주세요!");
								break;
							
							
							} //end 게시판 1_4 switch
						} //end 게시판 1_4 while
						
						break;
						
					case 5 : //회원정보수정
						System.out.println("수정할 회원정보를 입력해주세요!");
						
						System.out.print("수정할 회원 아이디 >> ");
						String cmId = sc.next();
						chimac.setCmId(cmId);
						
						System.out.print("비밀번호 >> ");
						String cmPw = sc.next();
						chimac.setCmPw(cmPw);
						
						System.out.print("이름 >> ");
						String cmName = sc.next();
						chimac.setCmName(cmName);
						
						System.out.print("생년월일 >> ");
						String cmBir = sc.next();
						chimac.setCmBir(cmBir);
						
						System.out.print("성별 >> ");
						String cmGen = sc.next();
						chimac.setCmGen(cmGen);
						
						System.out.print("이메일 >> ");
						String cmEmail = sc.next();
						chimac.setCmEmail(cmEmail);
						
						sc.nextLine();
						
						System.out.print("주소 >> ");
						String cmAdr = sc.nextLine();
						chimac.setCmAdr(cmAdr);
						
						System.out.print("전화번호 >> ");
						String cmPhone = sc.next();
						chimac.setCmPhone(cmPhone);
					
						server.memberModify(chimac);

						break;
						
					case 6 : //회원정보확인
						System.out.print("아이디 입력 >> ");
						cId = sc.next();
						
						System.out.print("비밀번호 입력 >> ");
						cPw = sc.next();
						
						check = server.idCheck(cId,cPw);
						
						if(check) {
							server.memberList(cId);
						} else {
							System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
						}
						
						break;
					
					case 7 : //회원탈퇴
						System.out.print("아이디 입력 >> ");
						cId = sc.next();
						
						System.out.print("비밀번호 입력 >> ");
						cPw = sc.next();
						
						check = server.idCheck(cId,cPw);
						
						if(check) {
							server.memberDelete(cId);
							run1 = false;
							break;
						} else {
							System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
						}
						
						break;
						
					case 8 : //로그아웃
						run1 = false;
						server.basketdelete();
						System.out.println("로그아웃 되었습니다!");
						break;
						
					default :
						System.out.println("다시 입력해주세요!");
						break;
						
					
					} //end case1 switch
					
					
				} //end case1 while
				
				} else {  //end if문 (아이디 일치) else문 (아이디 불일치)
					System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
				}
				break;
				
			case 2 : //회원가입
				System.out.println("회원정보를 입력해주세요!");
				
				System.out.print("아이디 >> ");
				String cmId = sc.next();
				chimac.setCmId(cmId);
				
				System.out.print("비밀번호 >> ");
				String cmPw = sc.next();
				chimac.setCmPw(cmPw);
				
				System.out.print("이름 >> ");
				String cmName = sc.next();
				chimac.setCmName(cmName);
				
				System.out.print("생년월일 >> ");
				String cmBir = sc.next();
				chimac.setCmBir(cmBir);
				
				System.out.print("성별 >> ");
				String cmGen = sc.next();
				chimac.setCmGen(cmGen);
				
				System.out.print("이메일 >> ");
				String cmEmail = sc.next();
				chimac.setCmEmail(cmEmail);
				
				sc.nextLine();
				
				System.out.print("주소 >> ");
				String cmAdr = sc.nextLine();
				chimac.setCmAdr(cmAdr);
				
				System.out.print("전화번호 >> ");
				String cmPhone = sc.next();
				chimac.setCmPhone(cmPhone);
				
				int cmBalance = 0;
				chimac.setCmBalance(cmBalance);
				
				
				server.memberJoin(chimac);
				
				break;
			case 3: // 종료
				run = false;
				System.out.println("종료 완료. 이용해주셔서 감사합니다.");
				break;
			default:
				System.out.println("항목 번호를 입력해주세요.");
				break;
			} // end switch
			
			
		} // end while
		server.conClose();

	}

}
