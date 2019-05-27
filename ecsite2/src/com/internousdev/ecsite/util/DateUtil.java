package com.internousdev.ecsite.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public String getDate() {
		Date date = new Date();
//		SimpleDateForma()
//		デフォルトのロケール、パターン、日付フォーマット記号を持つ、オブジェクトを生成します。
//		パターン
//		y→年(year) M→月(month) d→月における日にち。H→一日における時(0～23)	m→分 s→秒
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		format
//		→Dateを日時"文字列"にフォーマットします。
		return simpleDateFormat.format(date);
	}
}
