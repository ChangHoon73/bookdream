package kr.or.bookdream.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import kr.or.bookdream.vo.SearchBooks;

public class CommonUtil {
	public static String getNowDate(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		return String.format("%d%02d%02d", year,month, day);
	}
	
	public static String getNowTime(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		return String.format("%d%02d%02d%02d%02d%02d", year,month, day, hour, minute, second);
	}
	
	public static Vector<SearchBooks> getSearchBooks(String isbn){
		System.out.println("isbn"+isbn);
		Vector<SearchBooks> vc = null;
		try{
			vc = new Vector<SearchBooks>();
			String query = "https://apis.daum.net/search/book?apikey=13f281ab53c880a5f2645a01cd655d07&searchType=isbn&output=json&q="+isbn;
			System.out.println(query);
			URL url = new URL(query);
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String jsondata = br.readLine();
			System.out.println(jsondata);
			JSONParser parser = new JSONParser();
			
			JSONObject obj = (JSONObject) parser.parse(jsondata);
			JSONObject channel = (JSONObject) obj.get("channel");
			JSONArray items = (JSONArray) channel.get("item");
			JSONObject itemlist = (JSONObject) items.get(0);
			
			String author = itemlist.get("author").toString();
			String title = itemlist.get("title").toString();
			String link = itemlist.get("cover_l_url").toString();
			String publisher = itemlist.get("pub_nm").toString();
			String pdate = itemlist.get("pub_date").toString();
			System.out.println(author);
			System.out.println(title);
			System.out.println(link);
			System.out.println(publisher);
			System.out.println(pdate);
			vc.add(new SearchBooks(title, link, author, publisher, isbn, pdate));
		}catch(Exception err){
			
		}
		return vc;
	}
	
	/**
	 * 이미지 링크주소를 받아서 이미지를 뽑아서 이미지 라벨에 적용 함수
	 * @param linkurl
	 */
	public static ImageIcon getLinksImg(String linkurl, int width, int height){
		URL url = null;
		try {
			url = new URL(linkurl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedImage img = null;
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 이미지를 사이즈에 맞게 축소
		ImageIcon imgscale = new ImageIcon(img);
		Image image = imgscale.getImage().getScaledInstance(
				width, // 가로크기
				height, // 세로크기
				Image.SCALE_DEFAULT);
		ImageIcon imgIcon = new ImageIcon(
				image
				);
		//lbl_image.setIcon(imgIcon);
		return imgIcon;
		
	}
}
