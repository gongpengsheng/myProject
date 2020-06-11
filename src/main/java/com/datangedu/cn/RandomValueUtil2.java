package com.datangedu.cn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;
import java.util.Date;

import javax.script.ScriptException;
import javax.xml.crypto.Data;

/**
 * 随机生成用户手机号Tel，电视台名channel_name,种类名program_name,开始时间start_time,结束时间end_time,观看时长duration,开始观看时间start_time_c,结束观看时间end_time_c,是否付费,标记数据ranks
 * @author X-rapido 
 */
public class RandomValueUtil2 {
    public static String base = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static String firstName="赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
    private static String girl="秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
    private static String boy="伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
    private static String[] road="重庆大厦,黑龙江路,十梅庵街,遵义路,湘潭街,瑞金广场,仙山街,仙山东路,仙山西大厦,白沙河路,赵红广场,机场路,民航街,长城南路,流亭立交桥,虹桥广场,长城大厦,礼阳路,风岗街,中川路,白塔广场,兴阳路,文阳街,绣城路,河城大厦,锦城广场,崇阳街,华城路,康城街,正阳路,和阳广场,中城路,江城大厦,顺城路,安城街,山城广场,春城街,国城路,泰城街,德阳路,明阳大厦,春阳路,艳阳街,秋阳路,硕阳街,青威高速,瑞阳街,丰海路,双元大厦,惜福镇街道,夏庄街道,古庙工业园,中山街,太平路,广西街,潍县广场,博山大厦,湖南路,济宁街,芝罘路,易州广场,荷泽四路,荷泽二街,荷泽一路,荷泽三大厦,观海二广场,广西支街,观海一路,济宁支街,莒县路,平度广场,明水路,蒙阴大厦,青岛路,湖北街,江宁广场,郯城街,天津路,保定街,安徽路,河北大厦,黄岛路,北京街,莘县路,济南街,宁阳广场,日照街,德县路,新泰大厦,荷泽路,山西广场,沂水路,肥城街,兰山路,四方街,平原广场,泗水大厦,浙江路,曲阜街,寿康路,河南广场,泰安路,大沽街,红山峡支路,西陵峡一大厦,台西纬一广场,台西纬四街,台西纬二路,西陵峡二街,西陵峡三路,台西纬三广场,台西纬五路,明月峡大厦,青铜峡路,台西二街,观音峡广场,瞿塘峡街,团岛二路,团岛一街,台西三路,台西一大厦,郓城南路,团岛三街,刘家峡路,西藏二街,西藏一广场,台西四街,三门峡路,城武支大厦,红山峡路,郓城北广场,龙羊峡路,西陵峡街,台西五路,团岛四街,石村广场,巫峡大厦,四川路,寿张街,嘉祥路,南村广场,范县路,西康街,云南路,巨野大厦,西江广场,鱼台街,单县路,定陶街,滕县路,钜野广场,观城路,汶上大厦,朝城路,滋阳街,邹县广场,濮县街,磁山路,汶水街,西藏路,城武大厦,团岛路,南阳街,广州路,东平街,枣庄广场,贵州街,费县路,南海大厦,登州路,文登广场,信号山支路,延安一街,信号山路,兴安支街,福山支广场,红岛支大厦,莱芜二路,吴县一街,金口三路,金口一广场,伏龙山路,鱼山支街,观象二路,吴县二大厦,莱芜一广场,金口二街,海阳路,龙口街,恒山路,鱼山广场,掖县路,福山大厦,红岛路,常州街,大学广场,龙华街,齐河路,莱阳街,黄县路,张店大厦,祚山路,苏州街,华山路,伏龙街,江苏广场,龙江街,王村路,琴屿大厦,齐东路,京山广场,龙山路,牟平街,延安三路,延吉街,南京广场,东海东大厦,银川西路,海口街,山东路,绍兴广场,芝泉路,东海中街,宁夏路,香港西大厦,隆德广场,扬州街,郧阳路,太平角一街,宁国二支路,太平角二广场,天台东一路,太平角三大厦,漳州路一路,漳州街二街,宁国一支广场,太平角六街,太平角四路,天台东二街,太平角五路,宁国三大厦,澳门三路,江西支街,澳门二路,宁国四街,大尧一广场,咸阳支街,洪泽湖路,吴兴二大厦,澄海三路,天台一广场,新湛二路,三明北街,新湛支路,湛山五街,泰州三广场,湛山四大厦,闽江三路,澳门四街,南海支路,吴兴三广场,三明南路,湛山二街,二轻新村镇,江南大厦,吴兴一广场,珠海二街,嘉峪关路,高邮湖街,湛山三路,澳门六广场,泰州二路,东海一大厦,天台二路,微山湖街,洞庭湖广场,珠海支街,福州南路,澄海二街,泰州四路,香港中大厦,澳门五路,新湛三街,澳门一路,正阳关街,宁武关广场,闽江四街,新湛一路,宁国一大厦,王家麦岛,澳门七广场,泰州一路,泰州六街,大尧二路,青大一街,闽江二广场,闽江一大厦,屏东支路,湛山一街,东海西路,徐家麦岛函谷关广场,大尧三路,晓望支街,秀湛二路,逍遥三大厦,澳门九广场,泰州五街,澄海一路,澳门八街,福州北路,珠海一广场,宁国二路,临淮关大厦,燕儿岛路,紫荆关街,武胜关广场,逍遥一街,秀湛四路,居庸关街,山海关路,鄱阳湖大厦,新湛路,漳州街,仙游路,花莲街,乐清广场,巢湖街,台南路,吴兴大厦,新田路,福清广场,澄海路,莆田街,海游路,镇江街,石岛广场,宜兴大厦,三明路,仰口街,沛县路,漳浦广场,大麦岛,台湾街,天台路,金湖大厦,高雄广场,海江街,岳阳路,善化街,荣成路,澳门广场,武昌路,闽江大厦,台北路,龙岩街,咸阳广场,宁德街,龙泉路,丽水街,海川路,彰化大厦,金田路,泰州街,太湖路,江西街,泰兴广场,青大街,金门路,南通大厦,旌德路,汇泉广场,宁国路,泉州街,如东路,奉化街,鹊山广场,莲岛大厦,华严路,嘉义街,古田路,南平广场,秀湛路,长汀街,湛山路,徐州大厦,丰县广场,汕头街,新竹路,黄海街,安庆路,基隆广场,韶关路,云霄大厦,新安路,仙居街,屏东广场,晓望街,海门路,珠海街,上杭路,永嘉大厦,漳平路,盐城街,新浦路,新昌街,高田广场,市场三街,金乡东路,市场二大厦,上海支路,李村支广场,惠民南路,市场纬街,长安南路,陵县支街,冠县支广场,小港一大厦,市场一路,小港二街,清平路,广东广场,新疆路,博平街,港通路,小港沿,福建广场,高唐街,茌平路,港青街,高密路,阳谷广场,平阴路,夏津大厦,邱县路,渤海街,恩县广场,旅顺街,堂邑路,李村街,即墨路,港华大厦,港环路,馆陶街,普集路,朝阳街,甘肃广场,港夏街,港联路,陵县大厦,上海路,宝山广场,武定路,长清街,长安路,惠民街,武城广场,聊城大厦,海泊路,沧口街,宁波路,胶州广场,莱州路,招远街,冠县路,六码头,金乡广场,禹城街,临清路,东阿街,吴淞路,大港沿,辽宁路,棣纬二大厦,大港纬一路,贮水山支街,无棣纬一广场,大港纬三街,大港纬五路,大港纬四街,大港纬二路,无棣二大厦,吉林支路,大港四街,普集支路,无棣三街,黄台支广场,大港三街,无棣一路,贮水山大厦,泰山支路,大港一广场,无棣四路,大连支街,大港二路,锦州支街,德平广场,高苑大厦,长山路,乐陵街,临邑路,嫩江广场,合江路,大连街,博兴路,蒲台大厦,黄台广场,城阳街,临淄路,安邱街,临朐路,青城广场,商河路,热河大厦,济阳路,承德街,淄川广场,辽北街,阳信路,益都街,松江路,流亭大厦,吉林路,恒台街,包头路,无棣街,铁山广场,锦州街,桓台路,兴安大厦,邹平路,胶东广场,章丘路,丹东街,华阳路,青海街,泰山广场,周村大厦,四平路,台东西七街,台东东二路,台东东七广场,台东西二路,东五街,云门二路,芙蓉山村,延安二广场,云门一街,台东四路,台东一街,台东二路,杭州支广场,内蒙古路,台东七大厦,台东六路,广饶支街,台东八广场,台东三街,四平支路,郭口东街,青海支路,沈阳支大厦,菜市二路,菜市一街,北仲三路,瑞云街,滨县广场,庆祥街,万寿路,大成大厦,芙蓉路,历城广场,大名路,昌平街,平定路,长兴街,浦口广场,诸城大厦,和兴路,德盛街,宁海路,威海广场,东山路,清和街,姜沟路,雒口大厦,松山广场,长春街,昆明路,顺兴街,利津路,阳明广场,人和路,郭口大厦,营口路,昌邑街,孟庄广场,丰盛街,埕口路,丹阳街,汉口路,洮南大厦,桑梓路,沾化街,山口路,沈阳街,南口广场,振兴街,通化路,福寺大厦,峄县路,寿光广场,曹县路,昌乐街,道口路,南九水街,台湛广场,东光大厦,驼峰路,太平山,标山路,云溪广场,太清路".split(",");
    private static final String[] email_suffix="@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");
    private static String[] channel_name="CCTV1,CCTV2,CCTV3,CCTV4,CCTV5,CCTV6,CCTV7,CCTV8,CCTV9,CCTV10,湖南卫视,东方卫视,安徽卫视,浙江卫视,北京卫视,山东卫视,江苏卫视,江西卫视,河南卫视,重庆卫视,东南卫视,广西卫视,四川卫视,广东卫视,教育一套,旅游卫视,吉林卫视,山西卫视,云南卫视,天津卫视,辽宁卫视,湖北卫视,陕西卫视,贵州卫视,河北卫视,宁夏卫视,青海卫视,新疆卫视,西藏卫视,甘肃卫视,深圳卫视,厦门卫视,黑龙江,内蒙古".split(",");
    private static String[] program_name="焦点访谈,探索·发现,朝闻天下,天天饮食,科技博览,走近科学,新闻联播,今日说法,晚间新闻,第一来时间,证券时间,为您服务,开心辞典,经济与法,综艺快报,动物世界,快乐驿站,正大综艺,艺术人生,百家讲坛,中国新闻,中国文艺,国宝档案,成语故事,走遍中国,今日亚洲,华人世界,巅峰时刻,体坛快讯,体育新闻,赛车时2113代,农广天地,聚焦三农,人与自然,军5261事纪实,芝麻开门,军事报道,百战经典,超级战士,影视金曲,子午书简,动漫世界,每日歌曲,风华国乐,法治在线,共同关注".split(",");
    //private static String[] start_time_hours="00,01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23".split(",");
    //private static String[] start_time_moments="00,01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59".split(",");
    //private static String[] start_time_seconds="00,01,02,03,04,05,06,07,08,09,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59".split(",");
    public static int getNum(int start,int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }
    
    /**
     * 返回频道
     */
    public static String getChannel() {
    	int index=getNum(0,channel_name.length-1);
    	String first=channel_name[index];
    	return first;
    }
    
    /**
     * 返回节目
     */
    private static String price = "";
    public static String getProgram() {
    	int index=getNum(0,program_name.length-1);
    	String first=program_name[index];
        return first;
    }
    

    /**
     * 返回Email 
     * @param lMin 最小长度 
     * @param lMax 最大长度 
     * @return
     */
    public static String getEmail(int lMin,int lMax) {
        int length=getNum(lMin,lMax);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = (int)(Math.random()*base.length());
            sb.append(base.charAt(number));
        }
        sb.append(email_suffix[(int)(Math.random()*email_suffix.length)]);
        return sb.toString();
    }

    /**
     * 返回手机号码 
     */
    private static String[] telFirst="130,131,132,133,134,135,136,137,138,139,145,147,149,150,151,152,153,155,156,157,158,159,166,171,172,175,176,177,178,180,181,182,183,184,185,186,187,188,189,198,199".split(",");
    public static String getTel() {
        int index=getNum(0,telFirst.length-1);
        String first=telFirst[index];
        String second=String.valueOf(getNum(1,888)+10000).substring(1);
        String third=String.valueOf(getNum(1,9100)+10000).substring(1);
        return first+second+third;
    }

    /**
     * 返回中文姓名 
     */
    private static String name_sex = "";
    public static String getChineseName() {
        int index=getNum(0, firstName.length()-1);
        String first=firstName.substring(index, index+1);
        int sex=getNum(0,1);
        String str=boy;
        int length=boy.length();
        if(sex==0){
            str=girl;
            length=girl.length();
            name_sex = "女";
        }else {
            name_sex="男";
        }
        index=getNum(0,length-1);
        String second=str.substring(index, index+1);
        int hasThird=getNum(0,1);
        String third="";
        if(hasThird==1){
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;
    }

    /**
     * 返回地址 
     * @return
     */
    public static String getRoad() {
        int index=getNum(0,road.length-1);
        String first=road[index];
        String second=String.valueOf(getNum(11,150))+"号";
        String third="-"+getNum(1,20)+"-"+getNum(1,10);
        return first+second+third;
    }
    
    public static String getRandomString(int length,String flg) { //length表示生成字符串的长度 
    	String baseall = "ABCDEFGHJKLMNPRSTUVWXY0123456789"; 
    	String base = "ABCDEFGHJKLMNPRSTUVWXY"; 
    	String intbase = "0123456789";
    	Random random = new Random(); 
    	StringBuffer sb = new StringBuffer(); 
    	for (int i = 0; i < length; i++) { 
    	int number;
    	if("A".equals(flg)){
    	number =    random.nextInt(intbase.length());
    	sb.append(intbase.charAt(number)); 
    	}
    	else if("B".equals(flg)){
    	number =    random.nextInt(base.length());
    	sb.append(base.charAt(number)); 
    	}else {
    	number = random.nextInt(baseall.length()); 
    	sb.append(baseall.charAt(number)); 
    	} 
    	} 
    	return sb.toString(); 
    	} 
    
    
    /**
     * 返回开始时间和结束时间
     * @return
     * @throws ParseException 
     */
	public static String[] getStart() throws ParseException{
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		Random rhour = new Random();
    	Random rminute = new Random();
    	Random rsecond = new Random();
    	String starthour="00";
    	String endhour="00";
    	String startminute="00";
    	String endminute="00";
    	String startsecond="00";
    	String endsecond="00";
    	String start_hour_c="00";
    	String end_hour_c="00";
    	String start_minute_c="00";
    	String end_minute_c="00";
    	String start_second_c="00";
    	String end_second_c="00";
    	String add_hour_c="00";
    	String add_minute_c="00";
    	String add_second_c="00";
        String continued ;
        String lasthour;
        String lasthour1;
		//int index = getNum(0, start_time_hours.length - 1);
		//int index1 = getNum(0, start_time_moments.length - 1);
		//int index2 = getNum(0, start_time_seconds.length - 1);
		int first = rhour.nextInt(24);
		int second = rminute.nextInt(59);
		int third = rsecond.nextInt(59);
		int first1 = first + rhour.nextInt(24);
		int second1 = second + rminute.nextInt(59);
		int third1 = third + rsecond.nextInt(59);
		int second2 = rminute.nextInt(59);
		int third2 = rsecond.nextInt(59); 
		int second3 = rminute.nextInt(59);
		int third3 = rsecond.nextInt(59);
		
		while(first1>=24||second1>=60||third1>=60) {
			first1=first+rhour.nextInt(24);
	        second1=second+rminute.nextInt(60);
	        third1=third+rsecond.nextInt(60);
	    }
		
		if(first<10) {
			starthour="0"+first;
			lasthour=Integer.toString(first);
	    	}else {
	    		starthour=""+first;
	    		lasthour=Integer.toString(first);
	    	}
		if(second<10) {
	    	startminute="0"+second;
	        }else {
	        	startminute=""+second;
	        }
		if(third<10) {
	    	startsecond="0"+third;
	    	}else {
	    		startsecond=""+third;
	    	}
	    	
	    if(third1<10) {
	    	endsecond="0"+third1;
	    	}else if(third1>60){
	    		endsecond=Integer.toString(third1-60);
	    		endminute=Integer.toString(second1+1);
		    }else {
		    	endsecond=""+third1;
		    }
	    if(second1<10) {
	    	endminute="0"+second1;
	        }else if(second1>60){
	        	endminute=Integer.toString(second1-60);
	        	endhour=Integer.toString(first1+1);
	        	lasthour1=Integer.toString(first1+1);
	        }else {
	        	endminute=""+second1;
	        }
	    if(first1<10) {
	    	endhour="0"+first1;
	    	lasthour1=Integer.toString(first1);
	    	}else if(first1>24){
	    		endhour="0";
	    		lasthour1=Integer.toString(0);
	        }else {
	        	endhour=""+first1;
	        	lasthour1=Integer.toString(first1);
	        }
	    
	    if(first1<10&&first1-first>2&&first+1<10) {
	    	endhour="0"+Integer.toString(first+1);
	    	lasthour1=Integer.toString(first+1);
	    }else if(first1<10&&first1-first<2){
	    	endhour="0"+first1;
	    	lasthour1=Integer.toString(first1);
	    }else if(first1>10&&first1-first>2&&first+1<10){
	    	endhour="0"+Integer.toString(first+1);
	    	lasthour1=Integer.toString(first+1);
	    }else if(first1>10&&first1-first<2){
	    	endhour=""+first1;
	    	lasthour1=Integer.toString(first1);
	    }else {
	    	endhour=Integer.toString(first+1);
	    	lasthour1=Integer.toString(first+1);
	    }
	    
	    if(second2>second-30 && second2<second+30 && second2>0 && second2<10 && third2>third-30 && third2<third+30 && third2>0 && third2<10) {
	    	start_second_c="0"+second2;
	    	start_minute_c="0"+third2;
	    	start_hour_c=starthour;	    	
	    }else if(second2>second-30 && second2<second+30 && second2>10 && second2<60 && third2>third-30 && third2<third+30 && third2>10 && third2<60) {
	    	start_second_c=""+second2;
	    	start_minute_c=""+third2;
	    	start_hour_c=starthour;
	    }else {
	    	start_second_c=startsecond;
	    	start_minute_c=startminute;
	    	start_hour_c=starthour;
	    }
	    
	    if(second3>second1-30 && second3<second1+30 && second3>0 && second3<10 && third3>third1-30 && third3<third1+30 && third3>0 && third3<10) {
	    	end_second_c="0"+second3;
	    	end_minute_c="0"+third3;
	    	end_hour_c=endhour;	    	
	    }else if(second3>second1-30 && second3<second1+30 && second3>10 && second3<60 && third3>third1-30 && third3<third1+30 && third3>10 && third3<60) {
	    	end_second_c=""+second3;
	    	end_minute_c=""+third3;
	    	end_hour_c=endhour;
	    }else {
	    	end_second_c=endsecond;
	    	end_minute_c=endminute;
	    	end_hour_c=endhour;
	    }
	    
	    int first2 = Integer.parseInt(lasthour);
	    int first3 = Integer.parseInt(lasthour1);
	    if(third3<third2 && second3>second2 && first3>=first2){
    		add_second_c=Integer.toString(third3+60-third2);
    		add_minute_c=Integer.toString(second3-1-second2);
    		add_hour_c=Integer.toString(first3-first2);
    	}else if(third3>=third2 && second3<second2 && first3>first2){
    		add_second_c=Integer.toString(third3-third2);
    		add_minute_c=Integer.toString(second3+60-second2);
    		add_hour_c=Integer.toString(first3-first2);
    	}else if(third3<third2 && second3<second2 && first3>first2){
    		add_second_c=Integer.toString(third3+60-third2);
    		add_minute_c=Integer.toString(second3+60-second2);
    		add_hour_c=Integer.toString(first3-1-first2);
    	}else if(third3>=third2 && second3>=second2 && first3>=first2){
    		add_hour_c=Integer.toString(first3-first2);
    		add_minute_c=Integer.toString(second3-second2);
    		add_second_c=Integer.toString(third3-third2);
    	}else {
    		add_hour_c=Integer.toString(0);
    		add_minute_c=Integer.toString(0);
    		add_second_c=Integer.toString(0);
    	}	
	    	String content=add_hour_c+":"+add_minute_c+":"+add_second_c;
	    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	    	long dateToSecond;
	    	try {
	            dateToSecond = 1L*sdf.parse(content).getTime();//sdf.parse()实现日期转换为Date格式，然后getTime()转换为毫秒数值
	            //System.out.print(dateToSecond);
	        }catch (ParseException e){
	            e.printStackTrace();
	        }
            continued =String.valueOf(1L*sdf.parse(content).getTime()).substring(1);
	    String a[]= {"0","1","2","3","4"};
    	a[0]=date.format(formatter)+" "+starthour+":"+startminute+":"+startsecond;
    	a[1]=date.format(formatter)+" "+endhour+":"+endminute+":"+endsecond;
    	a[2]=date.format(formatter)+" "+start_hour_c+":"+start_minute_c+":"+start_second_c;
    	a[3]=date.format(formatter)+" "+end_hour_c+":"+end_minute_c+":"+end_second_c;
    	a[4]=continued;
    	return a;
}
	
	
	/**
     * 是否付费 
     * @return
     */
	    public static String getRandom(int min, int max) {
	    	String a = "";
	    	Random random = new Random();
	        int s = random.nextInt(10) % 10 + 1;
	        if(s>1) {
	        	a = "否";
	        }else {
	        	a = "是";
	        }
	    	return a;        
	    }


	public static void main(String[] args) throws ParseException {
        for (int i = 0; i < 100; i++) {		
    			System.out.println(RandomValueUtil2.getChineseName());
    			System.out.println(name_sex);
    			System.out.println(RandomValueUtil2.getTel());
    			System.out.println(RandomValueUtil2.getEmail(6,9));  
    			System.out.println(RandomValueUtil2.getRoad());
    			System.out.println(RandomValueUtil2.getChannel());
    			System.out.println(RandomValueUtil2.getProgram());
    			String abc[]=RandomValueUtil2.getStart();
    	    	System.out.println("开始时间"+abc[0].toString());
    	    	System.out.println("结束时间"+abc[1].toString());
    	    	System.out.println("开始观看时间"+abc[2].toString());
    	    	System.out.println("结束观看时间"+abc[3].toString());
    	    	System.out.println("观看时长(ms)"+abc[4].toString());
    			//System.out.println(RandomValueUtil2.getStart());
    			//System.out.println(RandomValueUtil2.getEnd());
    			System.out.println(RandomValueUtil2.getRandom(1, 10));
    			
        }
        String file = "C:\\Users\\Gentle丶龚\\Desktop\\项目3\\test\\c.csv";
        try {
        	FileWriter writer = new FileWriter(file);
        	String header = "名字,性别,手机号,邮箱,地址,频道,节目,节目开始时间,节目结束时间,开始观看时间,结束观看时间,观看时长,付费,数据标记\r\n";
        	writer.write(header);
        	int ranks=0;
        	for (int i = 0; i < 1000; i++) {
        		ranks+=1;
        	String abc[]=RandomValueUtil2.getStart();
        	writer.write(RandomValueUtil2.getChineseName()+","+name_sex+","+RandomValueUtil2.getTel()+","+RandomValueUtil2.getEmail(6,9)+","+RandomValueUtil2.getRoad()+","+RandomValueUtil2.getChannel()+","+RandomValueUtil2.getProgram()+","+abc[0].toString()+","+abc[1].toString()+","+abc[2].toString()+","+abc[3].toString()+","+abc[4].toString()+","+RandomValueUtil2.getRandom(1, 10)+","+ranks+"\n");// 写内容 
        	System.out.println(ranks);

        	}

        	writer.flush();// 清空缓冲区，立即将输出流里的内容写到文件里 
        	writer.close();// 关闭输出流，施放资源 
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
  //此行注释用于git上传验证
    
    
}  