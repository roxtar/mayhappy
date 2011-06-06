//
// Generated by JTB 1.2.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All void visitors must implement this interface.
 */
public interface Visitor {
   //
   // void Auto class visitors
   //
   public void visit(NodeList n);
   public void visit(NodeListOptional n);
   public void visit(NodeOptional n);
   public void visit(NodeSequence n);
   public void visit(NodeToken n);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( TopLevelDeclaration() )*
    * f1 -> <EOF>
    */
   public void visit(File n);

   /**
    * f0 -> MainClass()
    *       | ClassDeclaration()
    */
   public void visit(TopLevelDeclaration n);

   /**
    * f0 -> "public"
    * f1 -> "class"
    * f2 -> Identifier()
    * f3 -> "{"
    * f4 -> "public"
    * f5 -> "static"
    * f6 -> "void"
    * f7 -> "main"
    * f8 -> "("
    * f9 -> "String"
    * f10 -> "["
    * f11 -> "]"
    * f12 -> Identifier()
    * f13 -> ")"
    * f14 -> "{"
    * f15 -> Statement()
    * f16 -> "}"
    * f17 -> "}"
    */
   public void visit(MainClass n);

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> ( ClassMember() )*
    * f4 -> "}"
    */
   public void visit(ClassDeclaration n);

   /**
    * f0 -> MethodDeclaration()
    *       | ConstantDeclaration()
    *       | UpdatableFieldDeclaration()
    */
   public void visit(ClassMember n);

   /**
    * f0 -> "public"
    * f1 -> "static"
    * f2 -> "final"
    * f3 -> Type()
    * f4 -> Identifier()
    * f5 -> "="
    * f6 -> Expression()
    * f7 -> ";"
    */
   public void visit(ConstantDeclaration n);

   /**
    * f0 -> "public"
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> ";"
    */
   public void visit(UpdatableFieldDeclaration n);

   /**
    * f0 -> "public"
    * f1 -> ReturnType()
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( FormalParameterList() )?
    * f5 -> ")"
    * f6 -> Block()
    */
   public void visit(MethodDeclaration n);

   /**
    * f0 -> FormalParameter()
    * f1 -> ( FormalParameterRest() )*
    */
   public void visit(FormalParameterList n);

   /**
    * f0 -> FinalFormalParameter()
    *       | UpdatableFormalParameter()
    */
   public void visit(FormalParameter n);

   /**
    * f0 -> "final"
    * f1 -> Type()
    * f2 -> Identifier()
    */
   public void visit(FinalFormalParameter n);

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    */
   public void visit(UpdatableFormalParameter n);

   /**
    * f0 -> ","
    * f1 -> FormalParameter()
    */
   public void visit(FormalParameterRest n);

   /**
    * f0 -> VoidType()
    *       | Type()
    */
   public void visit(ReturnType n);

   /**
    * f0 -> "void"
    */
   public void visit(VoidType n);

   /**
    * f0 -> UpdatableArrayType()
    *       | NonArrayType()
    */
   public void visit(Type n);

   /**
    * f0 -> NonArrayType()
    * f1 -> "["
    * f2 -> ":"
    * f3 -> RankEquation()
    * f4 -> "]"
    */
   public void visit(UpdatableArrayType n);

   /**
    * f0 -> "rank"
    * f1 -> "=="
    * f2 -> IntegerLiteral()
    */
   public void visit(RankEquation n);

   /**
    * f0 -> BooleanType()
    *       | IntegerType()
    *       | DoubleType()
    *       | StringType()
    *       | PlaceType()
    *       | DistType()
    *       | RegionType()
    *       | PointType()
    *       | ClassNameType()
    */
   public void visit(NonArrayType n);

   /**
    * f0 -> "boolean"
    */
   public void visit(BooleanType n);

   /**
    * f0 -> "int"
    */
   public void visit(IntegerType n);

   /**
    * f0 -> "double"
    */
   public void visit(DoubleType n);

   /**
    * f0 -> "String"
    */
   public void visit(StringType n);

   /**
    * f0 -> "place"
    */
   public void visit(PlaceType n);

   /**
    * f0 -> "dist"
    * f1 -> "("
    * f2 -> ":"
    * f3 -> RankEquation()
    * f4 -> ")"
    */
   public void visit(DistType n);

   /**
    * f0 -> "region"
    * f1 -> "("
    * f2 -> ":"
    * f3 -> RankEquation()
    * f4 -> ")"
    */
   public void visit(RegionType n);

   /**
    * f0 -> "point"
    * f1 -> "("
    * f2 -> ":"
    * f3 -> RankEquation()
    * f4 -> ")"
    */
   public void visit(PointType n);

   /**
    * f0 -> Identifier()
    */
   public void visit(ClassNameType n);

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(Identifier n);

   /**
    * f0 -> Assignment()
    *       | AsyncStatement()
    *       | Block()
    *       | FinishStatement()
    *       | IfStatement()
    *       | LoopStatement()
    *       | PostfixStatement()
    *       | PrintlnStatement()
    *       | ReturnStatement()
    *       | ThrowStatement()
    *       | WhileStatement()
    */
   public void visit(Statement n);

   /**
    * f0 -> Expression()
    * f1 -> "="
    * f2 -> Expression()
    * f3 -> ";"
    */
   public void visit(Assignment n);

   /**
    * f0 -> "async"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Block()
    */
   public void visit(AsyncStatement n);

   /**
    * f0 -> "{"
    * f1 -> ( BlockStatement() )*
    * f2 -> "}"
    */
   public void visit(Block n);

   /**
    * f0 -> FinalVariableDeclaration()
    *       | UpdatableVariableDeclaration()
    *       | Statement()
    */
   public void visit(BlockStatement n);

   /**
    * f0 -> "final"
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> "="
    * f4 -> Expression()
    * f5 -> ";"
    */
   public void visit(FinalVariableDeclaration n);

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> "="
    * f3 -> Expression()
    * f4 -> ";"
    */
   public void visit(UpdatableVariableDeclaration n);

   /**
    * f0 -> "finish"
    * f1 -> Statement()
    */
   public void visit(FinishStatement n);

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> [ ElseClause() ]
    */
   public void visit(IfStatement n);

   /**
    * f0 -> "else"
    * f1 -> Statement()
    */
   public void visit(ElseClause n);

   /**
    * f0 -> "for"
    * f1 -> "("
    * f2 -> PointType()
    * f3 -> ExplodedSpecification()
    * f4 -> ":"
    * f5 -> Expression()
    * f6 -> ")"
    * f7 -> Statement()
    */
   public void visit(LoopStatement n);

   /**
    * f0 -> IdentifierList()
    */
   public void visit(ExplodedSpecification n);

   /**
    * f0 -> Identifier()
    */
   public void visit(PointName n);

   /**
    * f0 -> "["
    * f1 -> Identifier()
    * f2 -> ( IdentifierRest() )*
    * f3 -> "]"
    */
   public void visit(IdentifierList n);

   /**
    * f0 -> ","
    * f1 -> Identifier()
    */
   public void visit(IdentifierRest n);

   /**
    * f0 -> Expression()
    * f1 -> ";"
    */
   public void visit(PostfixStatement n);

   /**
    * f0 -> "System.out.println"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> ";"
    */
   public void visit(PrintlnStatement n);

   /**
    * f0 -> "return"
    * f1 -> [ Expression() ]
    * f2 -> ";"
    */
   public void visit(ReturnStatement n);

   /**
    * f0 -> "throw"
    * f1 -> "new"
    * f2 -> "RuntimeException"
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    * f6 -> ";"
    */
   public void visit(ThrowStatement n);

   /**
    * f0 -> "while"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public void visit(WhileStatement n);

   /**
    * f0 -> InclusiveOrExpression()
    *       | EqualsExpression()
    *       | NotEqualsExpression()
    *       | GreaterThanExpression()
    *       | PlusExpression()
    *       | MinusExpression()
    *       | TimesExpression()
    *       | DivideExpression()
    *       | SinExpression()
    *       | CosExpression()
    *       | PowExpression()
    *       | AbsExpression()
    *       | MapExpression()
    *       | RegionConstant()
    *       | UnaryMinusExpression()
    *       | CoercionToIntExpression()
    *       | CoercionToDoubleExpression()
    *       | TypeAnnotatedExpression()
    *       | FactoryBlock()
    *       | ArrayAccess()
    *       | DotDistribution()
    *       | DotIsFirst()
    *       | DotMethodCall()
    *       | DotIdentifier()
    *       | PrimaryExpression()
    */
   public void visit(Expression n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "|"
    * f2 -> Expression()
    */
   public void visit(InclusiveOrExpression n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "=="
    * f2 -> Expression()
    */
   public void visit(EqualsExpression n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "!="
    * f2 -> Expression()
    */
   public void visit(NotEqualsExpression n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> ">"
    * f2 -> Expression()
    */
   public void visit(GreaterThanExpression n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "+"
    * f2 -> Expression()
    */
   public void visit(PlusExpression n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "-"
    * f2 -> Expression()
    */
   public void visit(MinusExpression n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "*"
    * f2 -> Expression()
    */
   public void visit(TimesExpression n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "/"
    * f2 -> Expression()
    */
   public void visit(DivideExpression n);

   /**
    * f0 -> "Math"
    * f1 -> "."
    * f2 -> "sin"
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    */
   public void visit(SinExpression n);

   /**
    * f0 -> "Math"
    * f1 -> "."
    * f2 -> "cos"
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    */
   public void visit(CosExpression n);

   /**
    * f0 -> "Math"
    * f1 -> "."
    * f2 -> "pow"
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ","
    * f6 -> Expression()
    * f7 -> ")"
    */
   public void visit(PowExpression n);

   /**
    * f0 -> "Math"
    * f1 -> "."
    * f2 -> "abs"
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    */
   public void visit(AbsExpression n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "->"
    * f2 -> PrimaryExpression()
    */
   public void visit(MapExpression n);

   /**
    * f0 -> "["
    * f1 -> ColonExpression()
    * f2 -> ( ColonRest() )?
    * f3 -> "]"
    */
   public void visit(RegionConstant n);

   /**
    * f0 -> ","
    * f1 -> ColonExpression()
    */
   public void visit(ColonRest n);

   /**
    * f0 -> ColonPair()
    *       | Expression()
    */
   public void visit(ColonExpression n);

   /**
    * f0 -> Expression()
    * f1 -> ":"
    * f2 -> Expression()
    */
   public void visit(ColonPair n);

   /**
    * f0 -> "-"
    * f1 -> PrimaryExpression()
    */
   public void visit(UnaryMinusExpression n);

   /**
    * f0 -> "("
    * f1 -> "int"
    * f2 -> ")"
    * f3 -> Expression()
    */
   public void visit(CoercionToIntExpression n);

   /**
    * f0 -> "("
    * f1 -> "double"
    * f2 -> ")"
    * f3 -> Expression()
    */
   public void visit(CoercionToDoubleExpression n);

   /**
    * f0 -> "("
    * f1 -> TypeAnnotation()
    * f2 -> ")"
    * f3 -> Expression()
    */
   public void visit(TypeAnnotatedExpression n);

   /**
    * f0 -> UpdatableArrayType()
    *       | DistType()
    */
   public void visit(TypeAnnotation n);

   /**
    * f0 -> Literal()
    *       | This()
    *       | AllocationExpression()
    *       | Identifier()
    */
   public void visit(PrimaryExpression n);

   /**
    * f0 -> "this"
    */
   public void visit(This n);

   /**
    * f0 -> "dist.factory.block"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    */
   public void visit(FactoryBlock n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "["
    * f2 -> ExpressionList()
    * f3 -> "]"
    */
   public void visit(ArrayAccess n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "."
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( ExpressionList() )?
    * f5 -> ")"
    */
   public void visit(DotMethodCall n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "."
    * f2 -> "distribution"
    */
   public void visit(DotDistribution n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "."
    * f2 -> "isFirst"
    * f3 -> "("
    * f4 -> ")"
    */
   public void visit(DotIsFirst n);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "."
    * f2 -> Identifier()
    */
   public void visit(DotIdentifier n);

   /**
    * f0 -> NewObject()
    *       | NewUpdatableArray()
    */
   public void visit(AllocationExpression n);

   /**
    * f0 -> "new"
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ExpressionList() ]
    * f4 -> ")"
    */
   public void visit(NewObject n);

   /**
    * f0 -> "new"
    * f1 -> NonArrayType()
    * f2 -> "["
    * f3 -> Identifier()
    * f4 -> "]"
    * f5 -> [ ArrayInitializer() ]
    */
   public void visit(NewUpdatableArray n);

   /**
    * f0 -> IntegerLiteral()
    *       | FloatingPointLiteral()
    *       | StringLiteral()
    *       | HereLiteral()
    *       | DistUnique()
    */
   public void visit(Literal n);

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public void visit(IntegerLiteral n);

   /**
    * f0 -> <FLOATING_POINT_LITERAL>
    */
   public void visit(FloatingPointLiteral n);

   /**
    * f0 -> <STRING_LITERAL>
    */
   public void visit(StringLiteral n);

   /**
    * f0 -> "here"
    */
   public void visit(HereLiteral n);

   /**
    * f0 -> "dist.UNIQUE"
    */
   public void visit(DistUnique n);

   /**
    * f0 -> Expression()
    * f1 -> ( ArgumentRest() )*
    */
   public void visit(ExpressionList n);

   /**
    * f0 -> ","
    * f1 -> Expression()
    */
   public void visit(ArgumentRest n);

   /**
    * f0 -> "("
    * f1 -> PointType()
    * f2 -> ExplodedSpecification()
    * f3 -> ")"
    * f4 -> Block()
    */
   public void visit(ArrayInitializer n);

}

