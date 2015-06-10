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
		Question q1 = new Question("��� �� ���������� ������� �.���. Innovation Lab ��� ���?", "Samsung",
				"Samsung", "Microsoft", "Apple", "Sony", QuestionState.OPEN,
				42.674524, 23.330363);
		this.addQuestion(q1);

		Question q2 = new Question("��� ������� �� ������� ������������ ��������� ����?", "�������",
				"�������", "�������", "�������", "����", QuestionState.OPEN,
				42.684234, 23.324569);
		this.addQuestion(q2);
		
		Question q3 = new Question("��� �� �������� �� � �������� � ����?", "���������",
				"������������", "������������", "����������", "���������", QuestionState.OPEN,
				42.684312, 23.330559);
		this.addQuestion(q3);
		
		Question q4 = new Question("� ������� �� ��� �������� �� ��������� �������� ����� 1988�.?", "���������",
				"���������", "����� III", "������ II", "���������� ���������", QuestionState.INVISIBLE,
				42.659464, 23.331944);
		this.addQuestion(q4);
		
		Question q5 = new Question("��� � ������� ���������� ����� ��������� ������������?", "�������� �����",
				"����������� �����", "��������� �����", "��������� �����", "�������� �����", QuestionState.INVISIBLE,
				42.672213, 23.318732);
		this.addQuestion(q5);
		
		Question q6 = new Question("��� �� �������� �� � �� ������� �����?", "\"�������� ���������\"",
				"\"�����\"", "\"������� ����\"", "\"������� ����\"", "\"�������� ���������\"", QuestionState.INVISIBLE,
				42.679012, 23.329058);
		this.addQuestion(q6);
		
		Question q7 = new Question("����� � ������ ������� ���� � �������?", "27�",
				"17�", "27�", "37�", "47�", QuestionState.INVISIBLE,
				42.672773, 23.326264);
		this.addQuestion(q7);
		
		Question q8 = new Question("����� �� ����� � ������������ ����� \"������ � ������\"?", "�����������",
				"�������������", "������������", "��������", "�����������", QuestionState.INVISIBLE,
				42.679872, 23.320669);
		this.addQuestion(q8);
		
		Question q9 = new Question("����� ����� ��� ���� ������ ����� (����������� ��������)?", "6",
				"3", "4", "5", "6", QuestionState.INVISIBLE,
				42.678555, 23.320259);
		this.addQuestion(q9);
		
		Question q10 = new Question("��� ��� ���� ���������� ������� ���������?", "��. ���� ������",
				"��. ����������", "��. ���� ������", "��. �������� ������", "��. ���������� ������", QuestionState.INVISIBLE,
				42.676110, 23.334443);
		this.addQuestion(q10);	
		
		Question q11 = new Question("��� � ���-�������� (� ���-�������) ���� �� ���������� ��������?", "210",
				"100", "130", "210", "720", QuestionState.INVISIBLE,
				42.67456, 23.3326);
		this.addQuestion(q11);
		
		Question q12 = new Question("����� � ������ ���� �� ���������� ��� ������������ �� ���������� ��������?", "72",
				"42", "52", "62", "72", QuestionState.INVISIBLE,
				42.673873, 23.32944);
		this.addQuestion(q12);		
		
		Question q13 = new Question("���� �� ��� ����� �� ������ � ������������� ��������?", "��������",
				"��������", "�����", "������", "���������", QuestionState.INVISIBLE,
				42.683796, 23.333404);
		this.addQuestion(q13);	
		
		Question q14 = new Question("����� ������� �� ��������� ���������� � ������ ����?", "�� ������",
				"�� �����", "�� ������", "�� �����", "�� ��������", QuestionState.INVISIBLE,
				42.662683, 23.339979);
		this.addQuestion(q14);	
		
		Question q15 = new Question("��� ��� � �������� ���� ���� �� �������?", "���������������� �������",
				"����������� �������", "�������� �� �������", "�������� �� ��������", "���������������� �������", QuestionState.INVISIBLE,
				42.681311, 23.33179);
		this.addQuestion(q15);	
		
		Question q16 = new Question("�� ���� ��� �������� ���?", "������ ����������",
				"������ ����������", "������ ��������", "������ ��������", "������ ������", QuestionState.INVISIBLE,
				42.685622, 23.330205);
		this.addQuestion(q16);	
		
		Question q17 = new Question("�� ����� ������ � ���-������� �� ������������ ������?", "500",
				"300", "400", "500", "600", QuestionState.INVISIBLE,
				42.677167, 23.328942);
		this.addQuestion(q17);	
		
		Question q18 = new Question("��� �� ���������� �� ����� ���?", "120",
				"94", "98", "102", "120", QuestionState.INVISIBLE,
				42.67482, 23.333936);
		this.addQuestion(q18);	
		
		Question q19 = new Question("����� � ���� ��������� ��� �� ������������ ���������� ����?", "��. ����",
				"�����", "������", "����� ������ � ������", "��. ����", QuestionState.INVISIBLE,
				42.678618, 23.321694);
		this.addQuestion(q19);	
		
		Question q20 = new Question("��� �� �������������� �� � �� ������ ����� ���� ������ ������?", "����������",
				"���������� ����", "�������", "����������", "����� ����", QuestionState.INVISIBLE,
				42.671046, 23.320621);
		this.addQuestion(q20);	
		
		Question q21 = new Question("��� � ����������� �������� � �������� � �������?", "����� ����",
				"���� �������", "����� ����������", "������ �����", "����� ����", QuestionState.INVISIBLE,
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
