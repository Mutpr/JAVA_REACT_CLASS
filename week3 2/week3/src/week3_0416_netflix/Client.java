package week3_0416_netflix;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      Socket client = null;
      DataInputStream dis = null;
      DataOutputStream dos = null;

      try {
         client = new Socket("192.168.0.217", 26000);
         dis = new DataInputStream(client.getInputStream());
         dos = new DataOutputStream(client.getOutputStream());
      } catch(Exception e) {
         System.out.println("서버에 연결할 수 없습니다.");
         System.out.println("같은 에러가 반복된다면 관리자에게 문의하세요.");
         System.exit(0);
      }

      while(true) {
         try {
            System.out.println("<< Netflix 영화 관리 시스템 >>");
            System.out.println("1. 신규 영화 등록");
            System.out.println("2. 영화 목록 출력");
            System.out.println("3. 영화 검색 ( 제목으로 검색 )");
            System.out.println("4. 영화 삭제 ( ID로 삭제 )");
            System.out.println("5. 영화 정보 변경( ID로 변경 )");
            System.out.print(" >>");
            int menu = Integer.parseInt(sc.nextLine());

            dos.writeInt(menu);

            if(menu == 1) {
               String msg = dis.readUTF();
               System.out.println(msg);

               while(true) {
                  /* 영화제목 입력하라는 메시지 받아서 출력 */
                  String titlemsg = dis.readUTF();
                  System.out.println(titlemsg);
                  // readUTF() - DataInputStream 에서 UTF-8형식으로 작성된 문자열을 읽어옴
               
                  /* 사용자의 입력을 읽어서 서버로 전송 */
                  String title = sc.nextLine();
                  dos.writeUTF(title);
                  dos.flush();
                  // writeUTF() - DataOutputStream에서 클라이언트가 서버에 데이터 문자열을 보낼 때 사용
                  // flush() - 클라리언트가 서버에 데이터를 즉시 전송하고 버퍼를 비움
                  
                  
                  
                  /* 영화 장르를 입력하라는 메시지를 받아서 출력 */
                  String genremsg = dis.readUTF();
                  System.out.println(genremsg);

                  /* 사용자의 입력을 읽어서 서버로 전송 */
                  String genre = sc.nextLine();
                  dos.writeUTF(genre);
                  dos.flush();

                  /* 메시지를 받아 출력 */
                  String readmsg = dis.readUTF();
                  System.out.println(readmsg);

                  /* 사용자의 입력을 읽어서 서버로 전달 */
                  int inputmsg = Integer.parseInt(sc.nextLine());
                  dos.writeInt(inputmsg);
                  // writeInt() -  클라이언트가 서버에 정수 데이터 보낼 때 사용
                  dos.flush();

                  if(inputmsg == 0) {
                     break; // 입력 종료
                  }
               }
            } else if(menu == 2) {
               
               System.out.println("<< 영화 목록 >>");
               /* 영화 목록의 크기를 읽어와서 각 영화 정보를 출력 */
               
               int size = dis.readInt();
               // readInt() - 클라이언트가 서버로부터 정수 데이터 읽어올 때 사용
               
               for (int i = 0; i < size; i++) {
                  System.out.println(dis.readUTF());
                  System.out.println(dis.readUTF());
                  System.out.println(dis.readUTF());
                  System.out.println(dis.readUTF());
               }
               
               
            } else if(menu == 3) {
               /* 검색할 영화 제목 입력받고, 서버로 전달 */
               String searchTitle = sc.nextLine();
               dos.writeUTF(searchTitle);
               
               
               dos.flush();

               /* 서버로부터 응답을 받아 출력 */
               System.out.println(dis.readUTF());
               System.out.println(dis.readUTF());
               System.out.println(dis.readUTF());
               System.out.println(dis.readUTF());
               
            } else if(menu == 4) {
               /* 삭제할 영화의 id를 입력받고, 서버로 전송 */
               int deleteId = sc.nextInt();
               dos.writeInt(deleteId);
               dos.flush();
               
//               System.out.println(dis.readInt());
//               System.out.println(dis.readInt());
//               System.out.println(dis.readInt());
//               System.out.println(dis.readInt());
               
               

            } else if(menu == 5) {
               /* 변경할 영화의 id를 입력받고, 서버로 전송 */
               int updateId = Integer.parseInt(sc.nextLine());
               dos.writeInt(updateId);
               dos.flush();
               
               /* 새로운 제목을 입력받고, 서버로 전송 */
               String title = sc.nextLine();
               dos.writeUTF(title);
               dos.flush();
               
               /* 새로운 장르를 입력받고, 서버로 전송 */
               String genre = sc.nextLine();
               dos.writeUTF(genre);
               dos.flush();
            }
         } catch(Exception e) {
            e.printStackTrace();
            System.exit(0);
         }
      }
   }
}