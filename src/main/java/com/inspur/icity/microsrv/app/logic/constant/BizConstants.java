package com.inspur.icity.microsrv.app.logic.constant;

import com.inspur.icity.microsrv.base.constant.BaseBizConstants;

/**
 * 基础常量定义专用类
 */
public class BizConstants extends BaseBizConstants {
	//灰度发布
	public static final String IS_GRAY_SCALE_YES = "1";
	public static final String GRAY_SCALE_GROUP_CODE = "Android";
	//版本
	public static final String APP_VERSION_IS_BETA = "1";//公测版
	public static final String APP_VERSION_IS_FORMAL = "0";//正式版
	public static final String APP_VERSION_IS_ONLINE = "1";//版本上线
	public static final String APP_VERSION_IS_NOT_ONLINE = "0";//版本停用


	//手机端
	public static final class MOBILE {

		//手机操作系统
		public static final class OS_TYPE {
			public static final String ANDROID = "android";
			public static final String IOS = "ios";
		}

		//手机端应用强制更新标志
		public static final class APP_FORCE_UPDATE {
			public static final String YES = "1";//强制更新
			public static final String NO = "0";//不强制更新
		}
	}

	//城市
	public static final class CITY_SITE {

		//禁用状态
		public static final class DISABLE_STATUS {
			public static final String YES = "1";//禁用
			public static final String NO = "0";//未禁用
		}

		//开站状态
		public static final class OPEN_STATUS {
			public static final String OPEN = "1";//已开站
			public static final String CLOSE = "0";//未开站
		}

		//菜单状态
		public static final class MENU_OPTION {
			public static final class SECOND_POS {
				public static final String NEWS = "0";//资讯
				public static final String AROUND = "1";//周边
				public static final String URL_LINK = "9";//链接
			}
			public static final class THIRD_POS {
				public static final String SQUARE = "0";//广场
				public static final String AROUND = "1";//周边
				public static final String URL_LINK = "9";//链接
			}

		}
	}

	//应用与用户关系
	public static final class APP_USER {
		public static final class RELATION_TYPE {
			public static final String COLLECTED = "collectionApp";//收藏
		}
	}

	//α公测组groupCode
	public static final String CODE_A = "α";

	//β公测组groupCode
	public static final String CODE_B = "β";

	//α公测组
	public static final String CODE_A_VALUE = "1";

	//β公测组
	public static final String CODE_B_VALUE = "2";

	//正式版
	public static final String FORMAL_VALUE = "0";
}
