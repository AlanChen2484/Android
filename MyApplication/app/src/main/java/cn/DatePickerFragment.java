package cn;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

public class DatePickerFragment extends DialogFragment implements OnDateSetListener{


	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH);
		int day=c.get(Calendar.DAY_OF_MONTH);
		return new DatePickerDialog(getActivity(),this,year,month,day);
	}

	@Override
	public void onDateSet(DatePicker view, int year, int monthOfYear,
						  int dayOfMonth) {

	}

}
