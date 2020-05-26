package zakuto.tehilimtr;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InfoDetailFragment extends Fragment {
    private FragmentInfoDetailListener listener;
    private EditText editText;
    private Button button;

    public interface FragmentInfoDetailListener {
        void onInputInfoDetailSent(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmanet_info_detail, container, false);
        editText = v.findViewById(R.id.editText);
        button = v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.onInputInfoDetailSent(input);
            }
        });
        return v;
    }

    public void updateEditText(CharSequence newText) {
        editText.setText(newText);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInfoDetailListener) {
            listener = (FragmentInfoDetailListener) context;

        } else {
            throw new RuntimeException(context.toString() + " must implement FragmentInfoDetailListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
