package com.example.braingym.UI.Fragments.AttentivenessGames;

import androidx.lifecycle.ViewModel;

import com.example.braingym.Data.Games.GameCardInfo;
import com.example.braingym.Domain.App;
import com.example.braingym.R;
import com.example.braingym.UI.Activities.MainActivity.MainActivity;
import com.example.braingym.UI.Fragments.Adapters.GameCategoryAdapter;
import com.example.braingym.UI.Fragments.Adapters.onCardActionListener;

public class AttentivenessGamesViewModel extends ViewModel {
    private MainActivity _parent;
    private GameCategoryAdapter _gameCategoryAdapter;

    public AttentivenessGamesViewModel(MainActivity _parent){
        this._gameCategoryAdapter = new GameCategoryAdapter(
                App.getAttentivenessGameCards().getCardInfo(),
                R.layout.item_game_card);

        this._parent = _parent;

        _gameCategoryAdapter.setActionListener(new onCardActionListener() {
            @Override
            public void onCardClickListener(GameCardInfo gameCategory) {
                _parent.Navigate(gameCategory.destinationID);
            }
        });
    }

    public GameCategoryAdapter getGameCategoryAdapter(){
        return _gameCategoryAdapter;
    }
}