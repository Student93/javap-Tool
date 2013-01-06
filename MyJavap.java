import java.io.*;
import java.lang.reflect.*;
class MyJavap
{

public static void main(String... s)throws IOException
{try
{
FileWriter br=new FileWriter(s[0]+".txt");
Class c=Class.forName(s[0]);
Class c1=c;
BufferedWriter fw=new BufferedWriter(br);
String s1="Compiled from "+s[0]+".java";
fw.write(s1);
fw.newLine();
int m=c1.getModifiers();
if(Modifier.isPublic(m))
fw.write("public");
if(Modifier.isFinal(m))
fw.write("and Final");
if(Modifier.isAbstract(m))
fw.write("and Abstract");
fw.write(" class "+s[0]+" extends ");

Class cs=c.getSuperclass();
while(cs!=null)
{
fw.write(cs.getName()+",");
c=cs;
cs=c.getSuperclass();


}
fw.write(" and Implements ");
Class inter[]=c1.getInterfaces();
for(int i=0;i<inter.length;i++)
fw.write(inter[i].getName()+",");
fw.write("{");
fw.newLine();
Field f[]=c1.getFields();
for(int i=0;i<f.length;i++)
{

fw.write(" "+f[i].getType().getName()+" "+f[i].getName()+";");
fw.newLine();
}
Constructor c2[]=c1.getConstructors();
for(int i=0;i<c2.length;i++)
{
fw.write(c.getName()+"(");
Class type[]=c2[i].getParameterTypes();
for(int j=0;j<type.length;j++)
{

fw.write(type[j].getName()+",");
}
fw.write(")");
fw.newLine();
}

Method m1[]=c1.getMethods();
for(int i=0;i<m1.length;i++)
{

fw.write(m1[i].getReturnType().getName()+" "+m1[i].getName()+"(");
Class t[]=m1[i].getParameterTypes();
for(int k=0;k<t.length;k++)
fw.write(t[k].getName()+",");
fw.write(");");
fw.newLine();


}
Package p=c1.getPackage();
fw.newLine();
fw.write("Package ");
fw.write(p.getName());
fw.close();
}catch(Exception e)
{}

}





}