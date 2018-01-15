package com.walker.webwalker.service;

import org.springframework.stereotype.Service;
import com.walker.webwalker.util.diff_match_patch;

@Service
public class Comparison {

    private diff_match_patch diffTool;

    public Comparison(){
        diffTool = new diff_match_patch();
    }

    public toCompare(String currentElement){

    }
}
