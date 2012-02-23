{**
 *
 * This is the Pascal translation of simple-test.ejay, to illustrate what your
 * parser output should look like.
 *
 *}
program

    { The declarations from the  body of the EJay main function go here. }
    var i,j,k: integer;
    var x,y,z: real;
    var s: string;
    var a,b,c: boolean;

    procedure f(x:real; s:string; a:boolean):integer;
    begin
        if (a and x >= 0) then         { The simple Pascal subset has no while,
                                         so it's an if here. }
        begin
            if (a or x = "abc")
            then
                f := a                 { Return in Pascal is done by assigning
                                         a value to the procedure name. }
            else
                f := a+1
        end
    end;

    procedure g(): IntArray;
        var a0: array[0] of integer;   { All arrays in pascal must have
                                         non-empty dimensions. }
        var a1: array[10] of integer;
        var a2: array[10] of array[20] of array[30] of integer;

        { The Pascal subset has no record type, which is the equivalent of
          struct in EJay.  So, these declarations are commented out.

        var s1: record f1:integer; f2:real end;
        var s2: record f1:record f1:integer; f2:real; f3:string;
                                 f4: array[10] of boolean end; f2:integer end;
        }
    begin
        g := a0;
    end;

begin
    { The statements from the  body of the EJay main function go here. }
    i := j + k * 10 - f(x,s,a);
    print(i);                     { There's no print statement in Pascal,
                                    so it's a procedure call here. }

end.
