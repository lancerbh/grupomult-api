package br.com.grupomult.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DateUtilsTest {

	private static final int DAY = 9;
	private static final int MONTH = 2;
	private static final int YEAR = 2015;

	private static final String DATE_PATTERN_VALID = DateUtils.ISO8601_COMPLETE_DATE;
	private static final String DATE_PATTERN_NULL = null;
	private static final String DATE_PATTERN_EMPTY = "";
	private static final String DATE_PATTERN_INVALID = "xxxx-xx-xx";

	private static final Date DATE;
	static {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, YEAR);
		calendar.set(Calendar.MONTH, MONTH - 1);
		calendar.set(Calendar.DAY_OF_MONTH, DAY);
		DATE = calendar.getTime();
	}

	private static final String DATE_STRING = String.format("%s-%02d-%02d", YEAR, MONTH, DAY);
	private static final String DATE_STRING_NULL = null;
	private static final String DATE_STRING_EMPTY = "";
	private static final String DATE_STRING_INVALID = "xxxx-xx-xx";

	@Test
	public void testStringToDateWithDateFillAndPatternValidSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING, DATE_PATTERN_VALID);
		assertNotNull(date);
		LocalDate localDate = DateUtils.dateToLocalDate(date);
		assertEquals(YEAR, localDate.getYear());
		assertEquals(MONTH, localDate.getMonthValue());
		assertEquals(DAY, localDate.getDayOfMonth());
	}

	@Test
	public void testStringToDateWithDateFillAndPatternInvalidTreatExceptionSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING, DATE_PATTERN_INVALID);
		assertNull(date);
	}

	@Test
	public void testStringToDateWithDateFillAndPatternEmptyTreatExceptionSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING, DATE_PATTERN_EMPTY);
		assertNull(date);
	}

	@Test
	public void testStringToDateWithDateFillAndPatternNullTreatExceptionSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING, DATE_PATTERN_NULL);
		assertNull(date);
	}

	@Test
	public void testStringToDateWithDateNullAndPatternValidTreatExceptionSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING_NULL, DATE_PATTERN_VALID);
		assertNull(date);
	}

	@Test
	public void testStringToDateWithDateNullAndPatternInvalidTreatExceptionSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING_NULL, DATE_PATTERN_INVALID);
		assertNull(date);
	}

	@Test
	public void testStringToDateWithDateNullAndPatternEmptyTreatExceptionSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING_NULL, DATE_PATTERN_EMPTY);
		assertNull(date);
	}

	@Test
	public void testStringToDateWithDateNullAndPatternNullTreatExceptionSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING_NULL, DATE_PATTERN_NULL);
		assertNull(date);
	}

	@Test
	public void testStringToDateWithDateEmptyAndPatternValidTreatExceptionSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING_EMPTY, DATE_PATTERN_VALID);
		assertNull(date);
	}

	@Test
	public void testStringToDateWithDateEmptyAndPatternInvalidTreatExceptionSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING_EMPTY, DATE_PATTERN_INVALID);
		assertNull(date);
	}

	@Test
	public void testStringToDateWithDateEmptyAndPatternEmptyTreatExceptionSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING_EMPTY, DATE_PATTERN_EMPTY);
		assertNull(date);
	}

	@Test
	public void testStringToDateWithDateEmptyAndPatternNullTreatExceptionSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING_EMPTY, DATE_PATTERN_NULL);
		assertNull(date);
	}

	@Test
	public void testStringToDateWithDateInvalidAndPatternValidTreatExceptionSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING_INVALID, DATE_PATTERN_VALID);
		assertNull(date);
	}

	@Test
	public void testStringToDateWithDateInvalidAndPatternInvalidTreatExceptionSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING_INVALID, DATE_PATTERN_INVALID);
		assertNull(date);
	}

	@Test
	public void testStringToDateWithDateInvalidAndPatternEmptyTreatExceptionSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING_INVALID, DATE_PATTERN_EMPTY);
		assertNull(date);
	}

	@Test
	public void testStringToDateWithDateInvalidAndPatternNullTreatExceptionSuccess() {
		Date date = DateUtils.stringToDate(DATE_STRING_INVALID, DATE_PATTERN_NULL);
		assertNull(date);
	}

	@Test
	public void testDateToStringSuccess() {
		String date = DateUtils.dateToString(DATE, DATE_PATTERN_VALID);
		assertNotNull(date);
		assertEquals(DATE_STRING, date);
	}

	@Test
	public void testDateToLocalDateSuccess() {
		LocalDate localDate = DateUtils.dateToLocalDate(DATE);
		assertNotNull(localDate);
		assertEquals(YEAR, localDate.getYear());
		assertEquals(MONTH, localDate.getMonthValue());
		assertEquals(DAY, localDate.getDayOfMonth());
	}

}
