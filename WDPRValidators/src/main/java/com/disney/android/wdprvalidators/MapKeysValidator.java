package com.disney.android.wdprvalidators;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by venkatgonuguntala on 10/26/15.
 */
public class MapKeysValidator
{

    /**
     * Predicate to determine whether the input map object contains key from the input string array.
     * @param map
     * @param keys
     * @return boolean
     */
    public boolean hasMapKeys(Map<String, ?> map, String []keys){
        boolean result = false;
        if ( map != null && keys != null)
        {
            for(String key : keys)
            {
                if (map.containsKey(key))
                {
                    result = true;
                }
                else
                {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }


    /**
     * Checker to determine whether the input map object contains key from the input string array.
     * @param map
     * @param keys
     * @return List<String>
     */
    public List<String> checkForMapKeys(Map<String,?> map, String []keys)
    {
        List<String> list = new ArrayList<>();
        if (map != null && keys != null)
        {
            if(map.size() > 0)
            {
                for(String key : keys)
                {
                    if (!map.containsKey(key))
                    {
                        list.add(ValidatorConstant.ERR_MAP_MISSING_KEYS);
                        break;
                    }
                }
            }
            else
            {
                list.add(ValidatorConstant.ERR_MAP_NO_KEYS);
            }

        }
        else
        {
            list.add(ValidatorConstant.ERR_EMPTY_INPUT);
        }
        return list;
    }
}
