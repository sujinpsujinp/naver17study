package day1220_2;

public class DBServerSystem {
	//접근지정자 일단 default로 해보고 protected로도 수정해보자
	protected String dbServerName;
	int serverPort;
	
	public DBServerSystem() 
	{
		dbServerName="Oracle";
		serverPort=8080;
	}
	public DBServerSystem(String dbServerName)
	{
		this.dbServerName=dbServerName;
		this.serverPort=8080;
	}
	
	public DBServerSystem(String dbServerName, int serverPort)
	{
		this.dbServerName=dbServerName;
		this.serverPort=serverPort;
	}
	
	public void serverStart()
	{
		System.out.println(serverPort+" Port로"+dbServerName+" DB세팅 완료");
	}
	
	public void serverClose()
	{
		System.out.println(dbServerName+" DB Close 함");
	}
	
}
