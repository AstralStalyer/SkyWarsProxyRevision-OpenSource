package cn.starry.skywars.proxy.util;

import cn.starry.skywars.proxy.SkyWarsProxy;
import cn.starry.skywars.proxy.enums.Data;
import cn.starry.skywars.proxy.enums.GameMode;
import cn.starry.skywars.proxy.enums.KitType;
import cn.starry.skywars.proxy.enums.PerkType;
import cn.starry.skywars.proxy.database.KeyValue;
import org.bukkit.entity.Player;
import org.json.JSONObject;


public class DataUtils {
    public static String get(Player p,Data data,Data.field field){
        return SkyWarsProxy.getDataBase().dbSelectFirst(data.getWhere(),field.getWhere(),new KeyValue("UUID",p.getUniqueId().toString()));
    }
    public static String get(Player p, Data.field field, GameMode gm, KitType kitType){
        return SkyWarsProxy.getDataBase().dbSelectFirst(Data.JOB.getWhere(),field.getWhere(),new KeyValue(){{
            add("UUID",p.getUniqueId().toString());
            add("KitName",gm.name()+kitType.name());
        }});
    }
    public static String get(Player p, Data.field field, GameMode gm, PerkType perkType){
        return SkyWarsProxy.getDataBase().dbSelectFirst(Data.PERK.getWhere(),field.getWhere(),new KeyValue(){{
            add("UUID",p.getUniqueId().toString());
            add(Data.field.PERKNAME.getWhere(),gm.name()+perkType.name());
        }});
    }
    public static void set(Player p,Data.field field,Integer i){
        if(SkyWarsProxy.getDataBase().dbSelectFirst(field.getTable().getWhere(),field.getWhere(),new KeyValue("UUID",p.getUniqueId().toString())) == null) {
            SkyWarsProxy.getDataBase().dbInsert(field.getTable().getWhere(),new KeyValue("UUID",p.getUniqueId().toString()));
        }
        SkyWarsProxy.getDataBase().dbUpdate(field.getTable().getWhere(),new KeyValue(field.getWhere(),i),new KeyValue("UUID",p.getUniqueId().toString()));
    }
    public static void set(Player p,Data.field field,GameMode gm, KitType kitType,Integer i){
        if(SkyWarsProxy.getDataBase().dbSelectFirst(Data.JOB.getWhere(),field.getWhere(),new KeyValue(){{add("UUID",p.getUniqueId().toString());add(Data.field.KitNAME.getWhere(),gm.name()+kitType.name());}}) == null) {
            SkyWarsProxy.getDataBase().dbInsert(field.getTable().getWhere(),new KeyValue(){{
                add(Data.field.UUID.getWhere(),p.getUniqueId().toString());
                add(Data.field.KitNAME.getWhere(),gm.name()+kitType.name());
            }});
        }
        SkyWarsProxy.getDataBase().dbUpdate(Data.JOB.getWhere(),new KeyValue(field.getWhere(),i),new KeyValue(){{
            add(Data.field.UUID.getWhere(),p.getUniqueId().toString());
            add(Data.field.KitNAME.getWhere(),gm.name()+kitType.name());
        }});
    }
    public static void set(Player p,Data.field field,GameMode gm, PerkType perkType,Integer i){
        if(SkyWarsProxy.getDataBase().dbSelectFirst(Data.PERK.getWhere(),field.getWhere(),new KeyValue(){{add("UUID",p.getUniqueId().toString());add(Data.field.PERKNAME.getWhere(),gm.name()+perkType.name());}}) == null) {
            SkyWarsProxy.getDataBase().dbInsert(field.getTable().getWhere(),new KeyValue(){{
                add(Data.field.UUID.getWhere(),p.getUniqueId().toString());
                add(Data.field.PERKNAME.getWhere(),gm.name()+perkType.name());
            }});
        }
        SkyWarsProxy.getDataBase().dbUpdate(Data.PERK.getWhere(),new KeyValue(field.getWhere(),i),new KeyValue(){{
            add(Data.field.UUID.getWhere(),p.getUniqueId().toString());
            add(Data.field.PERKNAME.getWhere(),gm.name()+perkType.name());
        }});
    }
    public static Integer getInt(Player p,Data data,Data.field field){
        if(data == Data.JOB) return null;
        return get(p,data,field) == null ? 0:Integer.parseInt(get(p,data,field));
    }
    public static Integer getInt(Player p, Data.field field, GameMode gm, KitType kitType){
        return get(p,field,gm,kitType) == null ? 0:Integer.parseInt(get(p,field,gm,kitType));
    }
    public static Integer getInt(Player p, Data.field field, GameMode gm, PerkType perkType){
        return get(p,field,gm,perkType) == null ? 0:Integer.parseInt(get(p,field,gm,perkType));
    }
    public static String getIntFormated(Player p,Data data,Data.field field){
        return MathUtils.Format(DataUtils.getInt(p, data, field));
    }
    public static String getIntFormated(Player p, Data.field field, GameMode gm, KitType kitType){
        return MathUtils.Format(getInt(p, field, gm,kitType));
    }

    public static Integer getTotalStat(Player p,Data.field field,String keyvalue){
        if(get(p,Data.PLAYERINFO,field) == null) return 0;
        JSONObject jo = new JSONObject(get(p,Data.PLAYERINFO,field));
        int result = 0;
        for (String s : jo.keySet()) {
            if(s.contains(keyvalue)){
                result = result+ jo.getInt(s);
            }
        }
        return result;
    }

}
