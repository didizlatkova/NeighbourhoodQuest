package com.fmi.neighbourhoodquest;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 15;
	private static final String DATABASE_NAME = "NeighbourhoodQuest";
	private static final String TABLE_QUEST = "quest";
	private static final String KEY_ID = "id";
	private static final String KEY_QUES = "question";
	private static final String KEY_ANSWER = "answer";
	private static final String KEY_OPT1 = "opt1";
	private static final String KEY_OPT2 = "opt2";
	private static final String KEY_OPT3 = "opt3";
	private static final String KEY_OPT4 = "opt4";
	private static final String KEY_STATE = "state";
	private static final String KEY_LAT = "lat";
	private static final String KEY_LONG = "long";
	private SQLiteDatabase dbase;

	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase = db;
		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPT1 + " TEXT, "
				+ KEY_OPT2 + " TEXT, " + KEY_OPT3 + " TEXT, " + KEY_OPT4
				+ " TEXT, " + KEY_STATE + " TEXT, " + KEY_LAT + " REAL, "
				+ KEY_LONG + " REAL)";

		db.execSQL(sql);
		addQuestions();
	}
	
	public void dropTable(){
		this.getWritableDatabase().execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
	}

	private void addQuestions() {
		Question q1 = new Question("Коя от компаниите направи т.нар. Innovation Lab във ФМИ?", "Samsung",
				"Samsung", "Microsoft", "Apple", "Sony", QuestionState.OPEN,
				42.674524, 23.330363);
		this.addQuestion(q1);

		Question q2 = new Question("Коя граница на Лозенец представлява Перловска река?", "северна",
				"източна", "западна", "северна", "южна", QuestionState.OPEN,
				42.684234, 23.324569);
		this.addQuestion(q2);
		
		Question q3 = new Question("Кое от следните не е факултет в УАСГ?", "стопански",
				"архитектурен", "геодезически", "строителен", "стопански", QuestionState.OPEN,
				42.684312, 23.330559);
		this.addQuestion(q3);
		
		Question q4 = new Question("В двореца на кой владетел се разполага зоопарка преди 1988г.?", "Фердинанд",
				"Фердинанд", "Борис III", "Симеон II", "Александър Батемберг", QuestionState.INVISIBLE,
				42.659464, 23.331944);
		this.addQuestion(q4);
		
		Question q5 = new Question("Как е наричан „Кемпински Хотел Зографски“ първоначално?", "Японския хотел",
				"Виетнамския хотел", "Корейския хотел", "Китайския хотел", "Японския хотел", QuestionState.INVISIBLE,
				42.672213, 23.318732);
		this.addQuestion(q5);
		
		Question q6 = new Question("Коя от творбите не е на Димитър Димов?", "\"Железния светилник\"",
				"\"Тютюн\"", "\"Осъдени души\"", "\"Поручик Бенц\"", "\"Железния светилник\"", QuestionState.INVISIBLE,
				42.679012, 23.329058);
		this.addQuestion(q6);
		
		Question q7 = new Question("Колко е висока Водната кула в Лозенец?", "27м",
				"17м", "27м", "37м", "47м", QuestionState.INVISIBLE,
				42.672773, 23.326264);
		this.addQuestion(q7);
		
		Question q8 = new Question("Музей за какво е Националният музей \"Земята и хората\"?", "минералогия",
				"палеонтология", "антропология", "геохимия", "минералогия", QuestionState.INVISIBLE,
				42.679872, 23.320669);
		this.addQuestion(q8);
		
		Question q9 = new Question("Колко етажа има Сити център София (включително подземни)?", "6",
				"3", "4", "5", "6", QuestionState.INVISIBLE,
				42.678555, 23.320259);
		this.addQuestion(q9);
		
		Question q10 = new Question("Чие име носи Софийската духовна семинария?", "Св. Иван Рилски",
				"Св. Вартоломей", "Св. Иван Рилски", "Св. Архангел Михаил", "Св. Александър Невски", QuestionState.INVISIBLE,
				42.676110, 23.334443);
		this.addQuestion(q10);	
		
		Question q11 = new Question("Коя е най-голямата (и най-студена) зала на Химическия факултет?", "210",
				"100", "130", "210", "720", QuestionState.INVISIBLE,
				42.67456, 23.3326);
		this.addQuestion(q11);
		
		Question q12 = new Question("Колко е общият брой на студентите при основаването на Физическия факултет?", "72",
				"42", "52", "62", "72", QuestionState.INVISIBLE,
				42.673873, 23.32944);
		this.addQuestion(q12);		
		
		Question q13 = new Question("Зала за кой спорт се намира в Биологическия факултет?", "волейбол",
				"волейбол", "тенис", "футбол", "баскетбол", QuestionState.INVISIBLE,
				42.683796, 23.333404);
		this.addQuestion(q13);	
		
		Question q14 = new Question("Какви изложби се провеждат периодично в Ловния парк?", "на кучета",
				"на котки", "на кучета", "на птици", "на насекоми", QuestionState.INVISIBLE,
				42.662683, 23.339979);
		this.addQuestion(q14);	
		
		Question q15 = new Question("Как още е наричана тази част на Лозенец?", "Журналистическия квартал",
				"Писателския квартал", "Квартала на поетите", "Квартала на богатите", "Журналистическия квартал", QuestionState.INVISIBLE,
				42.681311, 23.33179);
		this.addQuestion(q15);	
		
		Question q16 = new Question("На кого има паметник тук?", "Христо Смирненски",
				"Христо Смирненски", "Евлоги Георгиев", "Христо Георгиев", "Драган Цанков", QuestionState.INVISIBLE,
				42.685622, 23.330205);
		this.addQuestion(q16);	
		
		Question q17 = new Question("На колко години е най-старият от Славейковите дъбове?", "500",
				"300", "400", "500", "600", QuestionState.INVISIBLE,
				42.677167, 23.328942);
		this.addQuestion(q17);	
		
		Question q18 = new Question("Кой от автобусите не спира тук?", "120",
				"94", "98", "102", "120", QuestionState.INVISIBLE,
				42.67482, 23.333936);
		this.addQuestion(q18);	
		
		Question q19 = new Question("Какво е било работното име на метростанция Европейски съюз?", "Св. Наум",
				"Хемус", "Хилтън", "Музей Земята и хората", "Св. Наум", QuestionState.INVISIBLE,
				42.678618, 23.321694);
		this.addQuestion(q19);	
		
		Question q20 = new Question("Коя от метростанциите не е на същата линия като Джеймс Баучер?", "Опълченска",
				"Европейски съюз", "Сердика", "Опълченска", "Лъвов мост", QuestionState.INVISIBLE,
				42.671046, 23.320621);
		this.addQuestion(q20);	
		
		Question q21 = new Question("Кой е американски посланик в България в момента?", "Марси Рийс",
				"Джон Байърли", "Нанси Макълдауни", "Джеймс Уорли", "Марси Рийс", QuestionState.INVISIBLE,
				42.667661, 23.313062);
		this.addQuestion(q21);	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		onCreate(db);
	}

	public void addQuestion(Question quest) {
		ContentValues values = new ContentValues();
		values.put(KEY_QUES, quest.getQuestion());
		values.put(KEY_ANSWER, quest.getAnswer());
		values.put(KEY_OPT1, quest.getOption1());
		values.put(KEY_OPT2, quest.getOption2());
		values.put(KEY_OPT3, quest.getOption3());
		values.put(KEY_OPT4, quest.getOption4());
		values.put(KEY_STATE, quest.getState().toString());
		values.put(KEY_LAT, quest.getLatitude());
		values.put(KEY_LONG, quest.getLongitude());
		dbase.insert(TABLE_QUEST, null, values);
	}

	public ArrayList<Question> getAllQuestions() {
		ArrayList<Question> quesList = new ArrayList<Question>();
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase = this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQuestion(cursor.getString(1));
				quest.setAnswer(cursor.getString(2));
				quest.setOption1(cursor.getString(3));
				quest.setOption2(cursor.getString(4));
				quest.setOption3(cursor.getString(5));
				quest.setOption4(cursor.getString(6));
				quest.setState(QuestionState.valueOf(cursor.getString(7)));
				quest.setLatitude(cursor.getDouble(8));
				quest.setLongitude(cursor.getDouble(9));

				quesList.add(quest);
			} while (cursor.moveToNext());
		}
		cursor.close();
		return quesList;
	}

	public void changeQuestionState(int questionId, QuestionState newState) {
		String strFilter = KEY_ID + " = " + questionId;
		ContentValues args = new ContentValues();
		args.put(KEY_STATE, newState.toString());
		dbase = this.getWritableDatabase();
		dbase.update(TABLE_QUEST, args, strFilter, null);
	}

	public int rowcount() {
		int row = 0;
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row = cursor.getCount();
		cursor.close();
		return row;
	}
}
