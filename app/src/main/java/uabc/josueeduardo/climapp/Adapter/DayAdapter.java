package uabc.josueeduardo.climapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import uabc.josueeduardo.climapp.Model.Day;
import uabc.josueeduardo.climapp.R;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.DayViewHolder>{


    private Context mCtx;
    private List<Day> week;

    public DayAdapter(Context mCtx, List<Day> week) {
        this.mCtx = mCtx;
        this.week = week;
    }

    @NonNull
    @Override
    public DayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.card_view,null);
        return new DayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DayViewHolder holder, int position) {
    Day day=week.get(position);
    holder.addrs.setText(day.getAddrs());
    holder.shortDesc.setText(day.getWeatherDesc());
    holder.temp.setText(day.getTemp());
    }

    @Override
    public int getItemCount() {
       return week.size();
    }

    class DayViewHolder extends RecyclerView.ViewHolder {

        TextView addrs, shortDesc, temp;

        public DayViewHolder(@NonNull View itemView) {
            super(itemView);
            addrs=itemView.findViewById(R.id.addrsCv);
            shortDesc=itemView.findViewById(R.id.ShortDescCv);
            temp=itemView.findViewById(R.id.tempCv);
        }
    }
}
