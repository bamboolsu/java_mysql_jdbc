package java_main_test;
//import  com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
//import  com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
//import   com.taobao.api.DefaultTaobaoClient;
//import   com.taobao.api.TaobaoClient;

//�����MySQL���в�������ʱ�����import�Ͳ��ᱨ���ˣ�
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;

//�����������⣬����ҪJDBC�İ���ֱ��import���ɡ�
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;



public class SendMsg {
 public static void main(String[] args) {
  Connection conn = null;
  Statement stmt = null;
  ResultSet rs = null;
  String url = null;
  String user = null;
  String password = null;
  String sql = null;
  try {
   Class.forName("com.mysql.jdbc.Driver"); //����mysq����
  } catch (ClassNotFoundException e) {
   System.out.println("�������ش���");
   e.printStackTrace();//��ӡ������ϸ��Ϣ
  }
  try {
   url = 
    "jdbc:mysql://192.168.0.102/test?user=root&password=root&useUnicode=true&&characterEncoding=gb2312&autoReconnect = true";//��д����url = "jdbc:myqsl://localhost/test(���ݿ���)? user=root(�û�)&password=yqs2602555(����)";
   user = "root";
   password = "root";
   conn = DriverManager.getConnection(url,user,password);
  } catch (SQLException e) {
   System.out.println("���ݿ����Ӵ���");
   e.printStackTrace();
  }
  try {
   stmt = conn.createStatement();
   sql = "select * from dept";//dept���ű���deptno��deptname��age�������ֶ�
   rs = stmt.executeQuery(sql);//ִ��sql���
   while(rs.next()) {
    System.out.print(rs.getInt("deptno") + "   ");
    System.out.print(rs.getString("deptname") + "   ");
    System.out.println(rs.getInt("age") + "   ");
   }
  } catch (SQLException e) {
   System.out.println("���ݲ�������");
   e.printStackTrace();
  }
//�ر����ݿ�
  try {
   if(rs != null) {
    rs.close();
    rs = null;
   }
   if(stmt != null) {
    stmt.close();
    stmt = null;
   }
   if(conn != null) {
    conn.close();
    conn = null;
   }
  } catch(Exception e) {
   System.out.println("���ݿ�رմ���");
   e.printStackTrace();
  }
 }
}

