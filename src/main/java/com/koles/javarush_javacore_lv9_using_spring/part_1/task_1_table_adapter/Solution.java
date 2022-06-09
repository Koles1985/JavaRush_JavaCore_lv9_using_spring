
package com.koles.javarush_javacore_lv9_using_spring.part_1.task_1_table_adapter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("tableAdapter")
@Scope("prototype")
public class Solution {
    public Solution(){
        System.out.println("Table Adapter created!");
        ATable aTable = new ATable(){
          
            @Override
            public String getTableName(){
                return "DashBoardTable";
            }

            @Override
            public String getCurrentUserName() {
                return "Koles";
            }
        };
                
        TableAdapter tAdapter = new TableAdapter(aTable);
        System.out.println(tAdapter.getHeaderText());
    }
    
    public class TableAdapter implements BTable{
        private ATable aTable;
        public TableAdapter(ATable aTable){
            this.aTable = aTable;
        }
        
        @Override
        public String getHeaderText(){
            return "[" + aTable.getCurrentUserName() + "]:" 
                    + aTable.getTableName();
        }
    }
    
    public interface ATable{
        String getCurrentUserName();
        String getTableName();
    }
    
    public interface BTable{
        String getHeaderText();
    }
    
    
    
}
