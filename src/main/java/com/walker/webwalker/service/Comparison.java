package com.walker.webwalker.service;

import org.springframework.stereotype.Service;
import com.walker.webwalker.util.diff_match_patch;

import java.util.LinkedList;

@Service
public class Comparison {

    private diff_match_patch diffTool;

    public Comparison(){
        diffTool = new diff_match_patch();
    }

    public LinkedList<diff_match_patch.Diff> toCompare(String currentElement){
        // TODO: read old data from database
        String oldElement = "";
        return diffTool.diff_main(oldElement, currentElement);
    }
}
